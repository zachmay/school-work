(require "eval.lisp")

;; Define the environment in which execute the test suite. This includes
;; all the example functions defined in examples.lisp from the class 
;; website, plus some others to further test the deep binding additions.
(set 'DefaultEnvironment '(
  (consSelf (lambda (L) (cons L L)))
  (test1 (lambda (A) (cond ((eq A 1) "yes") (T "no"))))
  (lastElt (lambda (L)
        (cond
            ((null L) nil) ; L is empty: no last element
            ((null (cdr L)) (car L)) ; L is a one-element list
            (T (lastElt (cdr L)))))) ; recurse
  (incrementAll (lambda (L)
        (cond
            ((null L) nil) ; L is empty
            (T (cons (+ 1 (car L)) (incrementAll (cdr L)))))))
  (incrementAll2 (lambda (L A)
        (cond
            ((null L) nil) ; L is empty
            (T (cons (+ A (car L)) (incrementAll2 (cdr L) A)))
        )))
  (append (lambda (L1 L2)
        (cond
            ((null L1) L2)
            (T (cons (car L1) (append (cdr L1) L2))))))
  (ReverseIt (lambda (L)
        (cond
            ((null L) nil)
            (T (append (ReverseIt (cdr L)) (cons (car L) nil)))
        )))
  (ReverseAll (lambda (L)
        (cond
            ((atom L) L)
            (T (append (ReverseAll (cdr L))
                (cons (ReverseAll (car L)) nil))))))

  (mapcar (lambda (F Z)
        (cond
            ((null Z) nil)
            (t (cons (funcall F (car Z)) (mapcar F (cdr Z)))))))

  (makeAdder (lambda (N)
        (function (lambda (M) (+ N M)))))

  (threeDeep (lambda (A)
        (function (lambda (B)
            (function (lambda (C) (+ A B C)))))))

))

;; Execute test suite in DefaultEnvironment. The test suite is a list 
;; of (Expression ExpectedValue) pairs.
(run-test-suite DefaultEnvironment
  '(
    (nil nil)
    (1 1)
    ((cons nil nil) (nil))
    ((cons 1 nil) (1))
    ((cons (quote A) nil) (A))
    ((cons (quote A) (quote B)) (A . B))
    ((quote (A B)) (A B))
    ((cons (quote C) (quote (A B))) (C A B))
    ((cons 1 (cons 2 (cons 3 nil))) (1 2 3))
    ((quote (A B)) (A B))
    ((consSelf 1) (1 . 1))
    ((consSelf nil) (nil))
    ((consSelf (quote (A B))) ((A B) A B))
    ((cons (quote A) (cons (quote (B)) (cons (quote C) nil))) (A (B) C))
    (
      (cons (quote A) (cons (cons (quote B) nil) (cons (quote c) nil)))
      (A (B) C)
    )
    ((test1 1) "yes")
    ((test1 '1) "yes")
    ((test1 'a) "no")
    ((test1 2) "no")
    ((test1 (cons 1 nil)) "no")
    ((car (quote (A B))) A)
    ((cdr (quote (A B))) (B))
    ((car (quote (1))) 1)
    ((cdr (quote (1))) nil)
    ((car (quote (A . B))) A)
    ((cdr (quote (A . B))) B)
    ((lastElt nil) nil)
    ((lastElt (quote (1))) 1)
    ((lastElt (quote (1 2 3))) 3)
    ((lastElt (quote (1 (2 2) 3))) 3)
    ((lastElt (quote (1 2 (3 3)))) (3 3))
    ((incrementAll nil) nil)
    ((incrementAll '(1)) (2))
    ((incrementAll '(1 3 5)) (2 4 6))
    ((incrementAll2 nil 5) nil)
    ((incrementAll2 '(1) 5) (6))
    ((incrementAll2 '(1 3 5) 5) (6 8 10))
    ((ReverseIt (quote (a b))) (b a))
    ((ReverseIt (quote (a b (c d)))) ((c d) b a))
    ((ReverseIt (quote (a))) (a))
    ((ReverseIt ()) ())
    ((ReverseAll (quote (a b))) (b a))
    ((ReverseAll (quote (a b ((c d) e) f))) (f (e (d c)) b a))
    ((ReverseAll (quote (a))) (a))
    ((ReverseAll ()) ())
    ((ReverseAll (quote a)) a)
    ((append (quote (a b c)) nil) (a b c))
    ((append nil (quote (a b c))) (a b c))
    ((append (quote (a b c)) (quote (d e f))) (a b c d e f))
    ((mapcar (function (lambda (x) (* x x))) (quote (1 2 3 4))) (1 4 9 16))
    ((mapcar (function (lambda (x) (+ 1 x))) (quote (1 2 3 4))) (2 3 4 5))
    ((funcall (makeAdder 10) 11) 21)
    ((funcall (funcall (threeDeep 10) 20) 30) 60)
  )
)

