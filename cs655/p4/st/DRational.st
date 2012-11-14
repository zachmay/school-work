Number subclass: #DRational.
DRational instanceVariableNames: 'magnitude dimension'.
DRational comment: 'I represent a rational number with a dimension annotation.'.

DRational class extend
[
    " Class constructor methods. "
    new [
        ^ super new init.
    ]

    new: mag [
        ^ super new init: mag.
    ]

    new: mag in: dim [
        ^ super new init: mag in: dim.
    ]

    " Some built-in 'constructors' for common measures. "
    scalar: aRational [
        ^ self new: aRational in: (Dimension scalar).
    ]

    meter [
        ^ self new: (1 %% 1) in: (Dimension length).
    ]

    foot [
        ^ (self scalar: (3048 %% 10000)) * self meter.
    ]

    yard [
        ^ self scalar: (3 %% 1) * self foot.
    ]

    second [
        ^ self new: (1 %% 1) in: (Dimension time).
    ]

    minute [
        ^ self new: (60 %% 1) in: (Dimension time).
    ]

    hour [
        ^ self new: (3600 %% 1) in: (Dimension time).
    ]
]

DRational extend
[
    " Instance initialization methods. "
    init [
        magnitude := Rational new.
        dimension := Dimension scalar.
    ]

    init: mag [
        magnitude := mag.
        dimension := Dimension scalar.
    ]

    init: mag in: dim [
        magnitude := mag.
        dimension := dim.
    ]

    " Turn a DRational into a displayable string. "
    printString [
        ^ (self mag printString), ' ', (self dim printString)
    ]

    " Force dimension-compatibility. "
    dimensionSafe: aDRational [
        (self dim = aDRational dim) ifFalse: [
            self error: 'Incompatible dimensions'.
        ]
    ]

    " DRational equality. "
    = aDRational [
        ^ (self mag = aDRational mag) & (self dim = aDRational dim).
    ]

    < aDRational [
        self dimensionSafe: aDRational.
        ^ (self mag < aDRational mag).
    ]

    <= aDRational [
        self dimensionSafe: aDRational.
        ^ (self mag < aDRational mag) | (self mag = aDRational mag).
    ]

    > aDRational [
        self dimensionSafe: aDRational.
        ^ (self mag > aDRational mag).
    ]

    >= aDRational [
        self dimensionSafe: aDRational.
        ^ (self mag > aDRational mag) | (self mag = aDRational mag).
    ]

    " DRational addition. "
    + aDRational [
        self dimensionSafe: aDRational.
        ^ DRational new: (self mag + aDRational mag) in: (self dim).
    ]

    " DRational subtraction. "
    - aDRational [
        self dimensionSafe: aDRational.
        ^ DRational new: (self mag - aDRational mag) in: (self dim).
    ]

    " DRational multiplication. "
    * aDRational [
        ^ DRational new: (self mag * aDRational mag)
                     in: (self dim * aDRational dim).
    ]

    " DRational division. "
    / aDRational [
        ^ DRational new: (self mag / aDRational mag)
                     in: (self dim / aDRational dim).
    ]

    " Getter for magnitude. "
    mag [
        ^ magnitude.
    ]
    
    " Getter for dimension. "
    dim [
        ^ dimension.
    ]
]
