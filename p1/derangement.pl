#!/usr/bin/perl -W

use strict;
use warnings;

print "Begin listing derangements\n";

foreach my $d (derange(4))
{
    printList(@$d);
}

#
# derange
#
# Given a positive integer $n, return all
# derangements of the list [1, ..., $n].
#
sub derange
{
    my ($n) = @_;

    # Initialize storage for remaining items per level
    my @remain;
    for ( my $i = 0; $i <= $n; $i++ )
    {
        $remain[$i] = [()];
    }

    $remain[0] = [(1 .. $n)];

    printList(@{$remain[0]});

    my @derangements;
    foreach my $i (@{$remain[0]})
    {
        print "i = $i \n";
        if ( $i != 1 )
        {
	     $remain[1] = [deleteFromListByValue($i, @{$remain[0]})];
             foreach my $j (@{$remain[1]})
             {
                 print "\tj = $j \n";
                 if ( $j != 2 )
                 {
	             $remain[2] = [deleteFromListByValue($j, @{$remain[1]})];
                     foreach my $k (@{$remain[2]})
                     {
                         print "\t\tk = $k \n";
                         if ( $k != 3 )
                         {
	                     $remain[3] = [deleteFromListByValue($k, @{$remain[2]})];
                             foreach my $m (@{$remain[3]})
                             {
                                 print "\t\t\tm = $m \n";
                                 if ( $m != 4 )
                                 {
                                     push @derangements, [($i, $j, $k, $m)];
                                 }
                             }
                         }
                     }
                 }
             }
        }
    } 

    return @derangements;
}

#
# printList
#
# Given a list, print the elements of the list
# delimited with commas, surrounded by square
# brackets.
#
sub printList
{
    my (@list) = @_;
    print "[", join(',', @list), "]\n";
}

#
# deleteFromListByValue
# 
# Given a list, make a return a copy of the list
# with the first occurrence of the given element
# excluded.
#
sub deleteFromListByValue
{
    my ($value, @list) = @_;

    my $found = 0;
    my @out = ();

    for ( my $i = 0; $i < @list; $i++ )
    {
        if ( !$found && $list[$i] == $value )
        {
            $found = 1;
        }
        else
        {
            push @out, $list[$i];
        }
    }
    return @out;
}

