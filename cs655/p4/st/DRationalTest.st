Test subclass: #DRationalTest.
DRationalTest instanceVariableNames: 'halfMeter oneFoot oneHour oneSecond'.
DRationalTest comment: 'Test suite for class DRational, dimensioned rationals.'.


DRationalTest extend
[
    setUp [
        halfMeter := DRational new: (1 %% 2) in: (Dimension length).
        oneFoot   := DRational foot.
        oneHour   := DRational hour.
        oneSecond := DRational second.
    ]

    testCreation [
        'Testing dimensioned rational creation methods...' displayNl.
        self for: (halfMeter dim length) expect: 1.
        self for: (halfMeter dim mass) expect: 0.
        self for: (halfMeter dim time) expect: 0.
        self for: (halfMeter dim angle) expect: 0.
        self for: (halfMeter mag num) expect: 1.
        self for: (halfMeter mag den) expect: 2.

        self for: (oneHour dim length) expect: 0.
        self for: (oneHour dim mass) expect: 0.
        self for: (oneHour dim time) expect: 1.
        self for: (oneHour dim angle) expect: 0.
        self for: (oneHour mag num) expect: 3600.
        self for: (oneHour mag den) expect: 1.
    ]

    testAddition [
        |oneFootPlusHalfMeter|
        'Testing dimensioned rational addition...' displayNl.
        oneFootPlusHalfMeter := DRational new: (8048 %% 10000) in: (Dimension length).
        self for: (oneFoot + halfMeter) expect: oneFootPlusHalfMeter.
        self failsOn: [oneFoot + oneHour].
    ]

    testSubtraction [
        |oneFootMinusHalfMeter|
        'Testing dimensioned rational subtraction...' displayNl.
        oneFootMinusHalfMeter := DRational new: (-1952 %% 10000) in: (Dimension length).
        self for: (oneFoot - halfMeter) expect: oneFootMinusHalfMeter.
        self failsOn: [oneFoot - oneHour].
    ]

    testMultiplication [
        |oneFootTimesHalfMeter oneFootTimesOneHour|
        'Testing dimensioned rational multiplication...' displayNl.
        oneFootTimesHalfMeter := DRational new: (1524 %% 10000) in: (Dimension new length: 2).
        self for: (oneFoot * halfMeter) expect: oneFootTimesHalfMeter.
        oneFootTimesOneHour := DRational new: (109728 %% 100) in: (Dimension length time: 1).
        self for: (oneFoot * oneHour) expect: oneFootTimesOneHour.
    ]

    testDivision [
        |oneFootDivHalfMeter oneFootDivOneHour|
        'Testing dimensioned rational division...' displayNl.
        oneFootDivHalfMeter := DRational new: (6096 %% 10000) in: (Dimension scalar).
        self for: (oneFoot / halfMeter) expect: oneFootDivHalfMeter.
        oneFootDivOneHour := DRational new: (127 %% 1500000) in: (Dimension length time: -1).
        self for: (oneFoot / oneHour) expect: oneFootDivOneHour.
    ]

    testRelationalOperators [
        'Testing dimensioned rational relational operators...' displayNl.
        self for: oneFoot = oneFoot expect: true.
        self for: oneFoot = ((DRational scalar: (3048 %% 10000)) * DRational meter) expect: true.
        self for: oneFoot < halfMeter expect: true.
        self for: oneFoot <= halfMeter expect: true.
        self for: oneFoot > halfMeter expect: false.
        self for: oneFoot >= halfMeter expect: false.
        self for: oneHour > oneSecond expect: true.
        self for: oneHour >= oneSecond expect: true.
        self for: oneHour < oneSecond expect: false.
        self for: oneHour <= oneSecond expect: false.
        self failsOn: [oneFoot < oneHour].
        self failsOn: [oneFoot <= oneHour].
        self failsOn: [oneFoot > oneHour].
        self failsOn: [oneFoot >= oneHour].
    ]
]
