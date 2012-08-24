import unittest

from itertools import permutations

from derangement import isDerangement, generateDerangements


class TestDerangementFunctions(unittest.TestCase):

    def test_is_derangement(self):
        self.assertTrue(isDerangement([]))
        self.assertTrue(isDerangement([3,1,2]))
        self.assertFalse(isDerangement([1,2,3]))

    def test_generate_derangements(self):
        n = 5
        initial = range(1, n + 1)
        perms = permutations(initial)
	expectedDerangements = filter(isDerangement, perms)
        actualDerangements = generateDerangements(n)
        self.assertEquals(actualDerangements, expectedDerangements)


if __name__ == '__main__':
    unittest.main()
