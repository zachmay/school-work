Object subclass: #Dimension.
Dimension instanceVariableNames: 'length mass time angle'.
Dimension comment: 'I represent the physical dimension of a value.'.

Dimension class extend
[
    " Dimension constructor. "
    new [
        ^ super new init.
    ]

    " Helper methods for several commonly used dimensions. "
    scalar [
        ^ self new.
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

    velocity [
        ^ self new length: 1;
                   time:   -1.
    ]

    acceleration [
        ^ self new length: 1;
                   time:   -2.
    ]

    area [
        ^ self new length: 2.
    ]
]

Dimension extend
[
    " Dimension instance initialization. "
    init [
        ^ self length: 0;
               mass:   0;
               time:   0;
               angle:  0.
    ]

    " Convert a Dimension to a printable representation. "
    printString 
    [
        ^ '(' , (length printString) , ','
              , (mass printString)   , ','
              , (time printString)   , ','
              , (angle printString)  , ')'.
    ]

    " Return a new Dimension with negated exponents. "
    invert [
        ^ Dimension new length: (length negated);
                        mass:   (mass negated);
                        time:   (time negated);
                        angle:  (angle negated).
    ]

    " Dimension multiplication. "
    * dim [
        ^ Dimension new length: (self length + dim length);
                        mass:   (self mass + dim mass);
                        time:   (self time + dim time);
                        angle:  (self angle + dim angle).
    ]

    " Dimension division. "
    / dim [
        ^ self * (dim invert).
    ]

    " Dimension equality. "
    = dim [
        ^ (self length = dim length)
        & (self mass   = dim mass)
        & (self time   = dim time)
        & (self angle  = dim angle).
    ]

    " Getters and setters for dimension exponents. "
    length    [ ^ length ]
    length: l [ length := l ]

    mass      [ ^ mass ]
    mass: m   [ mass := m ]

    time      [ ^ time ]
    time: t   [ time := t ]

    angle     [ ^ angle ]
    angle: a  [ angle := a ]
]
