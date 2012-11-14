Test subclass: #RationalTest.
RationalTest instanceVariableNames: 'zero three newOver zeroSimplified '
                                  , 'simplified1 simplified2 negSimplified1 '
                                  , 'negSimplified2 negSimplified3 '
                                  , 'negSimplified4 negSimplified5'.
RationalTest comment: 'Test suite for class Rational'.

RationalTest extend
[
    " Some test fixtures. "
    setUp [
        zero           := Rational new.                    "0/1"
        three          := Rational new: 3.                 "3/1"
        newOver        := Rational new: 1 over: 3.         "1/3"
        zeroSimplified := Rational new: 0 over: 100.       "0/1"
        simplified1    := Rational new: 20 over: 30.       "2/3"
        simplified2    := Rational new: 1200 over: 800.    "3/2"
        negSimplified1 := Rational new: 1 over: -3.        "1/3"
        negSimplified2 := Rational new: -2 over: 4.        "-1/2"
        negSimplified3 := Rational new: 2 over: -4.        "-1/2"
        negSimplified4 := Rational new: -1 over: -2.       "1/2"
        negSimplified5 := Rational new: -2 over: -4.       "1/2"
    ]

    testCreation [
        'Testing rational creation...' displayNl.
        self for: (zero num)           expect: 0.
        self for: (zero den)           expect: 1.
        self for: (three num)          expect: 3.
        self for: (three den)          expect: 1.
        self for: (newOver num)        expect: 1.
        self for: (newOver den)        expect: 3.
        self for: (zeroSimplified num) expect: 0.
        self for: (zeroSimplified den) expect: 1.
        self for: (simplified1 num)    expect: 2.
        self for: (simplified1 den)    expect: 3.
        self for: (simplified2 num)    expect: 3.
        self for: (simplified2 den)    expect: 2.
        self for: (negSimplified1 num) expect: -1.
        self for: (negSimplified1 den) expect: 3.
        self for: (negSimplified2 num) expect: -1.
        self for: (negSimplified2 den) expect: 2.
        self for: (negSimplified3 num) expect: -1.
        self for: (negSimplified3 den) expect: 2.
        self for: (negSimplified4 num) expect: 1.
        self for: (negSimplified4 den) expect: 2.
        self for: (negSimplified5 num) expect: 1.
        self for: (negSimplified5 den) expect: 2.
        self failsOn: [Rational new: 1 over: 0].
    ]

    testFancyCreation [
        'Testing rational creation with %%...' displayNl.
        self for: (0 %% 1)  expect: zero.
        self for: (2 %% -4) expect: negSimplified3.
        self failsOn: [2 %% 0].
    ]

    testAdd [
        'Testing rational addition...' displayNl.
        self for: (1 %% 2) + (1 %% 2)  expect: (1 %% 1).
        self for: (1 %% 2) + (-1 %% 2) expect: (0 %% 1).
        self for: (2 %% 3) + (1 %% 6)  expect: (5 %% 6).
        self for: (1 %% 1) + (1 %% 125)  expect: (126 %% 125).
    ]

    testSubtract [
        'Testing rational subtraction...' displayNl.
        self for: (1 %% 2) - (1 %% 2)  expect: (0 %% 1).
        self for: (1 %% 2) - (-1 %% 2) expect: (1 %% 1).
        self for: (2 %% 3) - (1 %% 6)  expect: (1 %% 2).
        self for: (1 %% 1) - (1 %% 125)  expect: (124 %% 125).
    ]

    testMultiply [
        'Testing rational multiplication...' displayNl.
        self for: (1 %% 2) * (1 %% 2)   expect: (1 %% 4).
        self for: (-1 %% 2) * (-1 %% 2) expect: (1 %% 4).
        self for: (1 %% 2) * (-1 %% 2)  expect: (-1 %% 4).
        self for: (2 %% 3) * (1 %% 6)   expect: (1 %% 9).
        self for: (1 %% 1) * (1 %% 125) expect: (1 %% 125).
        self for: (5 %% 1) * (1 %% 5)   expect: (1 %% 1).
    ]

    testDivide [
        'Testing rational division...' displayNl.
        self for: (1 %% 2) / (1 %% 2)   expect: (1 %% 1).
        self for: (-1 %% 2) / (-1 %% 2) expect: (1 %% 1).
        self for: (1 %% 2) / (-1 %% 2)  expect: (-1 %% 1).
        self for: (2 %% 3) / (1 %% 6)   expect: (4 %% 1).
        self for: (1 %% 1) / (1 %% 125) expect: (125 %% 1).
        self for: (5 %% 1) / (1 %% 5)   expect: (25 %% 1).
        self failsOn: [(2 %% 3) / (0 %% 1)].
    ]

    testRelationalOperators [
        'Testing relational operators on rationals...' displayNl.
        self for: (1 %% 2)  =  (1 %% 2) expect: true.
        self for: (1 %% 2)  <= (1 %% 2) expect: true.
        self for: (1 %% 2)  <  (1 %% 2) expect: false.
        self for: (1 %% 3)  <  (1 %% 2) expect: true.
        self for: (1 %% 2)  <  (1 %% 3) expect: false.
        self for: (-1 %% 2) <  (1 %% 2) expect: true.
        self for: (1 %% 2)  >= (1 %% 2) expect: true.
        self for: (1 %% 2)  >  (1 %% 2) expect: false.
        self for: (-1 %% 2) >  (1 %% 2) expect: false.
        self for: (1 %% 3)  >  (1 %% 2) expect: false.
        self for: (1 %% 2)  >  (1 %% 3) expect: true.
    ]
]
