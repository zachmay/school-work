Test subclass: #DimensionTest.
DimensionTest instanceVariableNames: 'scalar length mass time angle velocity acceleration area'.
DimensionTest comment: 'Test suite for class Dimension'.

DimensionTest extend
[
    setUp [
        scalar       := Dimension new.
        length       := Dimension length.
        mass         := Dimension mass.
        time         := Dimension time.
        angle        := Dimension angle.
        velocity     := Dimension velocity.
        acceleration := Dimension acceleration.
        area         := Dimension area.
    ]

    testCreation [
        'Testing creation of Dimension values.' displayNl.

        self for: (scalar length)       expect: 0.
        self for: (scalar mass)         expect: 0.
        self for: (scalar time)         expect: 0.
        self for: (scalar angle)        expect: 0.

        self for: (length length)       expect: 1.
        self for: (length mass)         expect: 0.
        self for: (length time)         expect: 0.
        self for: (length angle)        expect: 0.

        self for: (mass length)         expect: 0.
        self for: (mass mass)           expect: 1.
        self for: (mass time)           expect: 0.
        self for: (mass angle)          expect: 0.

        self for: (time length)         expect: 0.
        self for: (time mass)           expect: 0.
        self for: (time time)           expect: 1.
        self for: (time angle)          expect: 0.

        self for: (angle length)        expect: 0.
        self for: (angle mass)          expect: 0.
        self for: (angle time)          expect: 0.
        self for: (angle angle)         expect: 1.

        self for: (velocity length)     expect: 1.
        self for: (velocity mass)       expect: 0.
        self for: (velocity time)       expect: -1.
        self for: (velocity angle)      expect: 0.
        
        self for: (acceleration length) expect: 1.
        self for: (acceleration mass)   expect: 0.
        self for: (acceleration time)   expect: -2.
        self for: (acceleration angle)  expect: 0.

        self for: (area length)         expect: 2.
        self for: (area mass)           expect: 0.
        self for: (area time)           expect: 0.
        self for: (area angle)          expect: 0.
    ]

    testInversion [
        'Testing dimensional inversion...' displayNl.
        self for: (acceleration invert length) expect: -1.
        self for: (acceleration invert mass)   expect: 0.
        self for: (acceleration invert time)   expect: 2.
        self for: (acceleration invert angle)  expect: 0.

    ]

    testMultiplication [
        'Testing dimensional multiplication...' displayNl.
        self for: (scalar * acceleration) expect: acceleration.
        self for: (length * length) expect: area.
        self for: (velocity * time) expect: length.
    ]

    testDivision [
        'Testing dimensional division...' displayNl.
        self for: (length / length)       expect: scalar.
        self for: (time / time)           expect: scalar.
        self for: (mass / mass)           expect: scalar.
        self for: (angle / angle)         expect: scalar.
        self for: (length / time)         expect: velocity.
        self for: (area / length)         expect: length.
        self for: (velocity / time)       expect: acceleration.
        self for: (acceleration / scalar) expect: acceleration.

    ]
]
