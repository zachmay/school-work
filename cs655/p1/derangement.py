from itertools import permutations
from goto import goto, label

def isDerangement(perm):
    if perm == []:
        return True
    n = len(perm)
    for i in xrange(n):
        if perm[i] == i + 1:
            return False
    return True

def generateDerangements(n):
    initial = range(1, n + 1)
    perms = map(list, permutations(initial))
    return filter(isDerangement, perms)    

def d(items, level=0):
    for i in items:
	print "Processing %d at level %d" % (i, level)
        if i != level:
            cleaned = list(items)
            cleaned.remove(i)
	    print "cleaned is " + str(cleaned)
            continuations = list(d(cleaned, level+1))
            print "Continuations are " + str(continuations)
            for more in d(cleaned, level+1):
                    yield i + more

def perms(items=[1,2,3], level=0):
    if items == []:
        return 
    elif len(items) == 1:
        yield items
        return
    for i in items:
        rest = list(items) 
        rest.remove(i)
        for continuation in perms(rest, level + 1):
            as_list = list(continuation)
            yield [i] + as_list

def d2(items=[1,2,3], level=0):
    if items == []:
        return 
    elif len(items) == 1:
        if level != items[0] - 1:
            yield items
            return
        else:
            yield None
            return
    for i in items:
        if level != i - 1:
            # Python is call-by-reference, so we copy the
            # list before modifying it.
	    rest = list(items)  
	    rest.remove(i)
	    for continuation in d2(rest, level + 1):
                if continuation != None:
	            as_list = list(continuation)
	            yield [i] + as_list

def derange(n):
    return list(d(range(n)))

def stupid(n=3):
    label .barf
    if 1 == 2:
        goto .barf
    initial = range(n)
    derange = []
    rest = list(initial)
    for i in rest:
        if i != 0:
            restI = list(rest)
            restI.remove(i) 
            for j in restI:
                if j != 1:
		    restJ = list(restI)
                    restJ.remove(j)
                    for k in restJ:
                        print rest, restI, restJ
                        if k != 2:
                            restK = list(restJ)
                            restK.remove(k)
                            for m in restK:
                                if m != 3:
				    derange.append([i,j,k,m])
    return derange

