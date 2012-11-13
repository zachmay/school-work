Object subclass: #Dimension.
Dimension instanceVariableNames: 'length mass time angle'.
Dimension comment: 'I represent the physical dimension of a value.'.

Dimension class extend
[
    new [
        ^ super new init.
    ]
    
    length [
        ^ self new length: 1.
    ]
    
    mass [
        ^ self new mass: 1.
    ]

    time [
        ^ self new time: 1.
    ]

    angle [
        ^ self new angle: 1.
    ]
]

Dimension extend
[
    init [
        ^ self length: 0;
               mass:   0;
               time:   0;
               angle:  0.
    ]

    printString 
    [
        ^ '(' , (length printString) , ','
              , (mass printString)   , ','
              , (time printString)   , ','
              , (angle printString)  , ')'.
    ]

    invert [
        self length: (length negated);
             mass:   (mass negated);
             time:   (time negated);
             angle:  (angle negated).
    ]

    * dim [
        ^ Dimension new length: (self length + dim length);
                        mass:   (self mass + dim mass);
                        time:   (self time + dim time);
                        angle:  (self angle + dim angle).
    ]

    / dim [
        ^ self * (dim invert).
    ]

    = dim [
        
    ]

    length    [ ^ length ]
    length: l [ length := l ]

    mass      [ ^ mass ]
    mass: m   [ mass := m ]

    time      [ ^ time ]
    time: t   [ time := t ]

    angle     [ ^ angle ]
    angle: a  [ angle := a ]
]
