#!/usr/bin/perl

# Disable deprecation warnings. Some versions
# of perl dislike goto into procedures.
no warnings 'deprecated';

# printList($listReference)
#
# Given a reference to a list, print the elements of that list.
#
sub printList
{
    @list = @{$_[0]};

    print("[" . join(", ", @list) . "]");
}

# okSoFar($i, $listReference)
#
# Helper function for derangements()
#
# Given an index i and reference to a list, check that:
#  1. The ith element of the list doesn't equal i
#  2. The ith element of the list doesn't also occur
#     at any position k < i.
#
sub okSoFar
{
    # Get parameters.
    $i = $_[0];
    @list = @{$_[1]}; # Dereference the list reference argument.

    $target = $list[$i];

    $ok = 1;

    # If list[i] == i, we fail.
    if ( $target == $i + 1 )
    {
        return 0;
    }

    # For each k < i, if list[k] == list[i], we fail.
    for ( my $k = 0; $k < $i; $k += 1 )
    {
        if ( $list[$k] == $target )
        {
            return 0;
        }
    }

    # In any other case, we're OK.
    return 1;
}

# derangements($n)
#
# Given an integer n > 0, print all derangements
# of the list [1, ..., n].

sub derangements
{

    # Get parameters.
    $n = $_[0];

    # Give a name to the starting index. Perhaps we'll change it later.
    $init = 0;

    # Initialize the derangement to zeros. This list will hold the derangement
    # we are currently working on. 
    @derangement = ();

    # Since we are translating power loop syntax into a series gotos, the below
    # code models each flowchart box in the diagram from [Finkel 96, p. 51].

    # Initialization. 
    initialization:
        $level = $init;

    # Upper conditional. Check upper bound on $level.
    # Can branch to body or replicatedPart.
    upperConditional:
        if ( $level >= $n )
        {
            goto body;
        }
        else
        {
            goto replicatedPart;
        }

    # Body. Code executed at the deepest level of nesting.
    # Branches to decrementLevel.
    body:
        printList(\@derangement);
        print("\n");
        goto decrementLevel;

    # Decrement Level. Decrease nesting level.
    # Branches to lowerConditional.
    decrementLevel:
        $level -= 1;
        goto lowerConditional;

    # Increment Level. Increase nesting level.
    # Branches to upperConditional.
    incrementLevel:
        $level += 1;
        goto upperConditional;

    # Replicated Part. Code replicated in each level of nesting.
    # Can branch to incrementLevel or decrementLevel.
    replicatedPart:
        for ( $derangement[$level] = $init + 1;
              $derangement[$level] <= $n;
              $derangement[$level] += 1 )
        {
            # print("derangement[$level] = " . $derangement[$level] . "\n");
            if ( okSoFar($level, \@derangement) )
            {
                goto incrementLevel;

                returnLabel:
            }
        }
        goto decrementLevel;

    # Lower Conditional: Check lower bound on $level.
    # Can branch to done, or to the return label within replicatedPart.
    lowerConditional:
        # print("Top of lowerConditional level = $level\n");
        if ( $level < $init )
        {
            goto done;
        }
        else
        {
            goto returnLabel;
        }


    # Done. Computation complete.
    done:
}

$argc = $#ARGV + 1;

if ( $argc != 1 || $ARGV[0] < 1 )
{
    print("\nUsage: derangement.pl n\nGiven n > 0,"
          . " print all derangements of [1, ..., n]\n");
    exit;
}

derangements($ARGV[0]);
