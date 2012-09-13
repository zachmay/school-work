import argparse
import sys
from itertools import permutations, imap, ifilter

def iterAppend(iterA, iterB):
    """
    Given two iterators, A and B, return a new
    iterator that iterates over the elements of
    A, then iterates over the elements of B. 
    """
    for x in iterA:
        yield x
    for x in iterB:
        yield x

def isDerangement(perm):
    """
    Predicate to test if a given list is a derangement.
    
    A list is a derangement if for each index i,
    0 <= i < len(list), list[i] != i + 1
    """
    if perm == []:
        return True
    n = len(perm)
    for i in xrange(n):
        if perm[i] == i + 1:
            return False
    return True

def derangements(n):
    """
    A helper function that, given n, calls the function
    derangements() on an initial list to build arecursively-
    defined generator of all derangements of that list.
    """
    if n < 1:
        raise ValueError('derangements() is only defined for n > 0');
    initial = range(1, n + 1)  # [1, ..., n]
    # derange() is a generator whose elements are themselves generators.
    # imap() is a higher-order generator that yields the value of its first
    # parameter applied to the elements # yielded by its second parameter,
    # another generator. We use this to lazily convert each derangement
    # from generator to a list. 
    return imap(list, derange(initial))

def derange(items, level=0):
    """
    derange is a recursive generator. Given a list
    of elements and the current depth, recursively yield
    all derangements of those items. By never choosing
    to use an item that equals the depth, we enforce the
    derangement property, that d_i != i
    """
    if items == []:
        yield iter([]) # return an empty iterator.
    for i in items:
        if level + 1 != i:
            # Python is call-by-reference, so we copy the
            # list before modifying it.
            rest = list(items)
            rest.remove(i)
            for continuation in derange(rest, level + 1):
                # I use iterAppend instead of converting 
                # continuation to a list and appending 
                # to keep evaluation lazy.
                yield iterAppend([i], continuation)

def naiveDerangements(n):
    """
    A naive derangement generator, for reference. This uses
    python's itertools.permutation method and filters based
    on the isDerangement predicate.
    
    We map list() over the results of itertools.permuatations
    because it returns tuples instead of lists.
    """
    if n < 1:
        raise ValueError('derangements() is only defined for n > 0');
    initial = range(1, n + 1) # [1, ..., n]
    # itertools.permutation() returns tuples, so we map those into
    # lists using itertools.imap() (see comment in derangements()).
    # Similarly, we use itertools.ifilter() to lazily filter the
    # permutations with by the isDerangement predicate.
    return ifilter(isDerangement, imap(list, permutations(initial)))

def main():
    # Parse command line arguments.
    argParser = argparse.ArgumentParser(
        description='For n > 0, print all derangements of [1, ..., n]')
    argParser.add_argument(
        'n',
        metavar='n',
        type=int,
        help='Upper bound of the list to derange, n > 0')
    argParser.add_argument(
        '--naive',
        '-n',
        help='Use naive algorithm (filter permutations)',
        action='store_true')
    args = argParser.parse_args()

    if args.n < 1:
        argParser.print_help()
        sys.exit(1)

    # If the user chose --naive, use the naive generator.
    # Otherwise, use the proper one.
    if args.naive:
        out = naiveDerangements(args.n)
    else:
        out = derangements(args.n)

    # Print the generated derangements.
    for x in out:
        print x

if __name__ == '__main__':
    main()
