" A class for rational numbers "
Number subclass: #Rational .
Rational instanceVariableNames: 'num den' .
Rational comment: 'A class to represent rational numbers' .

Rational class extend
[
    " New Rational, zero value. "
    new
    [
        ^ super new init: 0
    ]

    " New Rational, specifying numerator (denominator = 1). "
    new: numerator
    [
        ^ super new init: numerator
    ]

    " New Rational, specifying numerator and denominator. "
    new: numerator over: denominator
    [
        ^ super new init: numerator over: denominator.
    ]
]

Rational extend
[
    " Initialize a Rational equal to zero. "
    " - Delegates to init:over: "
    init
    [
        self init: 0 over: 1 .
    ]

    " Initialize a Rational with an integer value. "
    " - Delegates to init:over: "
    init: numerator
    [
        self init: numerator over: 1.
    ]

    " Initialize a Rational with a given numerator and denominator. "
    " - Error if denominator equals zero. "
    " - Reduces to reduced form, with any negative in the numerator."
    init: numerator over: denominator
    [ |gcd n d|
        (denominator = 0) ifTrue:
            [ self error: 'Denominator cannot be zero.' ].

        n := numerator.
        d := denominator.

        (d negative) ifTrue: [
            n := n negated.
            d := d negated
        ].

        gcd := numerator gcd: denominator.

        num := n quo: gcd.
        den := d quo: gcd.
    ]

    " Return a printable string representation of this Rational. "
    printString 
    [
        ^ (num printString) , '/' , (den printString).
    ]

    " Negate this Rational. "
    negated
    [
        ^ Rational new: (-1 * num) over: den.
    ]

    " Returns whether this Rational is negative. "
    negative
    [
        ^ num negative
    ]

    " Returns whether this Rational is positive. "
    positive
    [
        ^ num positive
    ]

    " Return the reciprocal of this Rational. "
    " - Error if numerator is zero. "
    reciprocal
    [
        (num = 0) ifTrue:
            [ self error: 'Reciprocal of zero-value Rational.' ].
        ^ Rational new: den over: num
    ]

    " Add a Rational to this Rational "
    + aRational
    [ |newNum newDen|
        
        newDen := (self den) * (aRational den).
        newNum := ((self num) * (aRational den)) + ((aRational num) * (self den)).

        ^ Rational new: newNum over: newDen
    ]

    " Subtract aRational from this Rational. "
    - aRational
    [
        ^ self + (aRational negated)
    ]

    " Multiply a Rational with this Rational "
    * aRational
    [ |newNum newDen|

        newNum := (self num) * (aRational num).
        newDen := (self den) * (aRational den).
        
        ^ Rational new: newNum over: newDen.
    ]

    " Divide this by aRational. "
    / aRational
    [ 
        ^ self * (aRational reciprocal)
    ]

    " Equality with aRational. "
    = aRational
    [
        ^ (self num = aRational num) & (self den = aRational den).
    ]

    " Simple accessors "
    num [ ^ num ]
    den [ ^ den ]
]

Integer extend
[
    %% anInteger
    [
        ^ Rational new: self over: anInteger.
    ]
]
!
