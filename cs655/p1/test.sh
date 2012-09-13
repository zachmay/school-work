#!/bin/bash

[ ! -f test ] && mkdir test

echo
echo
echo "Testing derangements, n = 1"
echo
echo "Python, generators"
time python derangement.py 1 > test/python-generator-1
echo
echo "Python, naive"
time python derangement.py -n 1 > test/python-naive-1
echo
echo "Perl"
time ./derangement.pl 1 > test/perl-1
diff test/python-naive-1 test/python-generator-1
diff test/python-naive-1 test/perl-1

echo
echo
echo "Testing derangements, n = 5"
echo
echo "Python, generators"
time python derangement.py 5 > test/python-generator-5
echo
echo "Python, naive"
time python derangement.py -n 5 > test/python-naive-5
echo
echo "Perl"
time ./derangement.pl 5 > test/perl-5
diff test/python-naive-5 test/python-generator-5
diff test/python-naive-5 test/perl-5

echo
echo
echo "Testing derangements, n = 10"
echo
echo "Python, generators"
time python derangement.py 10 > test/python-generator-10
echo
echo "Python, naive"
time python derangement.py -n 10 > test/python-naive-10
echo
echo "Perl"
time ./derangement.pl 10 > test/perl-10
diff test/python-naive-10 test/python-generator-10
diff test/python-naive-10 test/perl-10
