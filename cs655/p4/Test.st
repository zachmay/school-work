Object subclass: #Test.

Test class extend
[
    " Run through this Test suite's method dictionary looking for methods "
    " that being with 'test'. For each such method, instantiate a new "
    " instance of this class, set up fixtures, and perform the test method."
    run [
        self methodDictionary keysDo: [ :key |
            (key asString ~ '^test') ifTrue: [
                self new setUp; perform: key. 
            ]
        ]
    ]
]

Test extend
[
    " Set up a test suite's fixtures. Subclasses should override thsi to do "
    " something useful, if necessary. "
    setUp [] 

    " Testing method: compare an actual value to an expected value. "
    " On failure, throws an error describing the problem. "
    for: actual expect: expected [
        (actual = expected) ifFalse: [
            self error: 'Expected '
                      , expected printString
                      , '; got '
                      , actual printString.
        ]
    ]

    " Testing method: Test the expectation that a given block will "
    " fail with an Error. If the block does not fail, this test fails. "
    failsOn: block [
        block on: Error do: [^ self].
        self error: 'Expected failure, but was successful.'.
    ]
]

