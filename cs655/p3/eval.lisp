;; Metacircular Lisp evaluator in Lisp, implementing deep binding using
;; function and funcall.
;;
;; Also includes some custom functions to run automated tests of the
;; evaluator.
;;
;; Modified from code by Raphael Finkel and Bill Dieter.

;; my-eval/2
;; Evaluate an S-expression Sexpr in the environment Env
(defun my-eval (Sexpr Env)       
  (cond
    ((null Sexpr)            nil)                ; NIL evaluates to NIL
    ((numberp Sexpr)         Sexpr)              ; A number evaluates to itself
    ((stringp Sexpr)         Sexpr)              ; A string evaluates to itself
    ((eq t Sexpr)            Sexpr)              ; Atom T evaluates to itself
    ((atom Sexpr)            (lookup Sexpr Env)) ; Other atoms looked up in Env
    ((eq (car Sexpr) 'quote) (car (cdr Sexpr)))  ; QUOTE operator does no eval
    ((eq (car Sexpr) 'cond)  (eval-cond (cdr Sexpr) Env))     ; COND operator
    ((eq (car Sexpr) 'function) ; If Rest of Sexpr is a lambda expression, 
      (cond                     ; return a closure with Env as NLRE.
        ((eq (caadr Sexpr) 'lambda) (list 'closed (cadr Sexpr) Env))
        (t (error "Cannot build closure with non-atom or non-lambda!"))
      ) ; cond
    ) ; special function 'function'
    (t
      (my-apply (car Sexpr) (eval-list (cdr Sexpr) Env) Env)  ; Apply function
    ) ; default case
  ) ; cond
) ; my-eval

;; my-apply/3
;; Apply the function Func to parameter list Params in environment Env.
;; Includes several "built-in" functions
(defun my-apply (Func Params Env) ; apply fct to parms
  (cond
    ((atom Func)
      (cond
        ((eq Func 'car) (car (car Params)))
        ((eq Func 'cdr) (cdr (car Params)))
        ((eq Func 'cons) (cons (car Params) (car (cdr Params))))
        ((eq Func 'get) (get (car Params) (car (cdr Params))))
        ((eq Func 'atom) (atom (car Params)))
        ((eq Func 'error) (error (string Params)))
        ((eq Func 'eq) (eq (car Params) (car (cdr Params))))
        ((eq Func 'null) (eq (car Params) nil)) ; Added case for null predicate
        ((eq Func '+) (apply '+ Params)) ; Added addition operator
        ((eq Func '*) (apply '* Params)) ; Added multiplication operator
        ((eq Func 'funcall)              ; Apply a closure to a parameter list
          (apply-closure                 
            (car Params)
            (eval-list (cdr Params) Env)
          ) ; apply-closure call
        ) ; funcall case
        (t (cond                         ; Apply a normal function to a
            ((get Func 'EXPR)            ; parameter list.
             (my-apply (get Func 'EXPR) Params Env) Params Env)
            (t (my-apply (lookup Func Env) Params Env)))
        ) ; normal function application case.
      ) ; cond
    ) ; Func is atomic
    ((eq (car Func) 'lambda)
      (my-eval (car (cdr (cdr Func)))
               (update-env (car (cdr Func)) Params Env)
      )
    ) ; Func is a lambda expression
    (t (my-apply (my-eval Func Env) Params Env))
  ) ; cond
) ; my-apply

;; apply-closure/2
;; Apply the given closure against the given argument list, elements of
;; which have already been evaluated in their "native" environment.
(defun apply-closure (Closure Params)
  (cond
    ((eq (sel-closure-header Closure) 'closed) 
      (my-apply
        (sel-closure-lambda Closure)
        Params
        (sel-closure-environment Closure)
      ) ; my-apply call
    ) ; Closure is actually a closure built by function
    (t (error "Can't call apply-closure on a non-closure."))
  ) ; cond
) ; apply-closure
  
;; Helper "selector" functions to break apart the arguments
;; of calls to funcall; e.g., (closed lambda-expr env
;; Comments for each show what they should return with the above S-expr.
(defun sel-closure-header (Sexpr) (car Sexpr))               ; closed
(defun sel-closure-lambda (Sexpr) (cadr Sexpr))              ; lambda-expr
(defun sel-closure-environment (Sexpr) (caddr Sexpr))        ; env


;; eval-cond/2
;; Evaluate the conditional expression, given its list of conditions Conds
;; and an environment Env.
(defun eval-cond (Conds Env)
  (cond
    ((null Conds) nil)                      ; No matched conditions -> error?
    ((my-eval (car (car Conds)) Env)        ; Condition evaluated to T, so
      (my-eval (car (cdr (car Conds))) Env) ;   evaluate condition's body.
    ) ; Condition evaluated to T.
    (t (eval-cond (cdr Conds) Env))         ; Condition did not evaluate to T.
  ) ; cond
) ; eval-cond

;; eval-list/2
;; Evaluate the list Sexpr in environment Env
(defun eval-list (Sexpr Env)
  (cond
    ((null Sexpr) nil)
    (t
      (cons (my-eval (car Sexpr) Env)
            (eval-list (cdr Sexpr) Env)
      ) ; cons
    ) ; Condition T
  ) ; cond
) ; eval-list

;; lookup/2
;; Lookup the identifier Id in environment Env
(defun lookup (Ident Env)
  (cond
    ((null Env) (error "Unbound identifier ~S" Ident))
    ((eq Ident (car (car Env))) (car (cdr (car Env))))
    (t (lookup Ident (cdr Env)))
  ) ; cond
) ; looup

;; update-env/3
;; Update the environment Env (as an association list), adding bindings
;; for identifiers from list Formals with values from list Actuals.
(defun update-env (Formals Actuals Env)
  (cond
    ((null Formals)
      (cond
        ((null Actuals) Env)
        (t (error "Bad argument count"))
      ) ; cond
    ) ; Formals is empty.
    ((null Actuals) (error "Bad argument count")) ; Actuals empty, Formals not.
    (t
      (cons (list (car Formals) (car Actuals))
            (update-Env (cdr Formals) (cdr Actuals) Env)
      ) ; cons
    ) ; Default condition
  ) ; cond
) ; update-env

;;;;;;;;;;;;;;;;;;;;;;;
;; Testing functions ;;
;;;;;;;;;;;;;;;;;;;;;;;

; test/3
; Evaluate an expression in the given environment. Determine whether
; this result is equal to the expected value, and return details.
(defun test (Environment Sexpr Expected)
  (let ((Actual (my-eval Sexpr Environment)))
    (list 
      (equal Actual Expected)
      Actual)
  ) ; Let binding
) ; test

; test-suite/5
; This does all the work for run-test-suite/2. It walks down the list of
; tests, evaluates the expression in Environment, and accumulates results.
; Accumulator parameters are used in this case since three different
; values have to be tracked.
(defun test-suite (Environment Tests Messages TotalPassed TotalExecuted)
  (cond
    ((null Tests) (list Messages TotalPassed TotalExecuted))
    (T
      (let ((Result (test Environment (caar Tests) (cadar Tests))))
        (cond 
          ((car Result)
            (test-suite Environment
                        (cdr Tests)
                        Messages
                        (+ 1 TotalPassed)
                        (+ 1 TotalExecuted))
          ) ; Test passed.
          (T (test-suite Environment
                         (cdr Tests)
                         (cons
                           (format
                             nil
                             "Expr.  ~S~%Expected    ~S~%Actual      ~S~%~%"
                             (caar Tests)
                             (cadar Tests)
                             (cadr Result))
                           Messages)
                         TotalPassed
                         (+ 1 TotalExecuted))
          ) ; Test did not pass.
        ) ; Cond - test passed?
      ) ; let binding
    ) ; Tests is not null
  ) ; Cond - Tests is null?
) ; test-suite
    
; run-test-suite/2
; Execute test suite in the given environment. The test suite is a list 
; of (Expression ExpectedValue) pairs. Statistics and failure details
; are accumulated and displayed.
(defun run-test-suite (Environment Tests)
  (let ((SuiteResults (test-suite Environment Tests () 0 0)))
    (mapcar (function (lambda (x) (format t x)))
      (append (car SuiteResults)
              (list (format nil "~D of ~D passed"
                                (cadr SuiteResults)
                                (caddr SuiteResults)))
      ) ; append
    ) ; mapcar
  ) ; let binding
) ; run-test-suite

