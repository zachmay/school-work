Object subclass: #Test.

Test extend
[
    for: actual expect: expected [
        (actual = expected)
            ifFalse: [ self error: ('Expected ', (expected printString), '; got ', (actual printString)). ]
    ]

    failsOn: block [
        block on: Error do: [^ self].
        self error: 'Expected failure, but was successful.'.
    ]
]

