from itertools import permutations

def isDerangement(perm):
    n = len(perm)
    for i in xrange(n):
        if perm[i] == i + 1:
            return False
    return True

def generateDerangements(n):
    initial = range(1, n + 1)
    perms = permutations(initial)
    return filter(isDerangement, perms)    
