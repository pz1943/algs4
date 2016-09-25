See the Assessment Guide for information on how to interpret this report.

Assessment Summary

Compilation:  PASSED
Style:        PASSED
Findbugs:     No potential bugs found.
API:          PASSED

Correctness:  19/26 tests passed
Memory:       8/8 tests passed
Timing:       9/9 tests passed

Aggregate score: 82.50% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]

Assessment Details

The following files were submitted:
----------------------------------
total 12K
-rw-r--r-- 1 3.0K Sep 16 02:29 Percolation.java
-rw-r--r-- 1 2.9K Sep 16 02:29 PercolationStats.java
-rw-r--r-- 1 2.0K Sep 16 02:29 studentSubmission.zip


********************************************************************************
*          COMPILING                                                           *
********************************************************************************


% javac Percolation.java
*-----------------------------------------------------------

================================================================

% javac PercolationStats.java
*-----------------------------------------------------------

================================================================



% checkstyle *.java
*-----------------------------------------------------------

================================================================


% findbugs *.class
*-----------------------------------------------------------

================================================================


Testing the APIs of your programs.
*-----------------------------------------------------------
Percolation:

PercolationStats:

================================================================


******************************************************************************
*          CORRECTNESS
******************************************************************************

Testing methods in Percolation
*-----------------------------------------------------------
Running 15 total tests.

Tests 1 through 8 create a Percolation object using your code, then repeatedly
open sites by calling open(). After each call to open(), we check the return
values of isOpen(i, j) for every (i, j), the return value of percolates(),
and the return value of isFull(i, j) for every (i, j), in that order.

Except as noted, a site is opened at most once.

Test 1: Open predetermined list of sites using file inputs
  *  filename = input6.txt
  *  filename = input8.txt
  *  filename = input8-no.txt
  *  filename = input10-no.txt
  *  filename = greeting57.txt
  *  filename = heart25.txt
==> passed

Test 2: Open random sites until just before system percolates
  *  n = 3
  *  n = 5
  *  n = 10
  *  n = 10
  *  n = 20
  *  n = 20
  *  n = 50
  *  n = 50
==> passed

Test 3: Opens predetermined sites for N = 1 and N = 2 (corner case test)
  *  filename = input1.txt
  *  filename = input1-no.txt
  *  filename = input2.txt
  *  filename = input2-no.txt
==> passed

Test 4: Check for backwash with predetermined sites
  *  filename = input20.txt
     isFull(18, 1) returns wrong value [after 231 sites opened]
     - student   = true
     - reference = false
     - failed after call 231 to isOpen()
  *  filename = input10.txt
     isFull(9, 1) returns wrong value [after 56 sites opened]
     - student   = true
     - reference = false
     - failed after call 56 to isOpen()
  *  filename = input50.txt
     isFull(22, 28) returns wrong value [after 1412 sites opened]
     - student   = true
     - reference = false
     - failed after call 1412 to isOpen()
  *  filename = jerry47.txt
     isFull(11, 47) returns wrong value [after 1076 sites opened]
     - student   = true
     - reference = false
     - failed after call 1076 to isOpen()
==> FAILED

Test 5: Check for backwash with predetermined sites that have
        multiple percolating paths
  *  filename = input3.txt
     isFull(3, 1) returns wrong value [after 4 sites opened]
     - student   = true
     - reference = false
     - failed after call 4 to isOpen()
  *  filename = input4.txt
     isFull(4, 4) returns wrong value [after 7 sites opened]
     - student   = true
     - reference = false
     - failed after call 7 to isOpen()
  *  filename = input7.txt
     isFull(6, 1) returns wrong value [after 12 sites opened]
     - student   = true
     - reference = false
     - failed after call 12 to isOpen()
==> FAILED

Test 6: Predetermined sites with long percolating path
  *  filename = snake13.txt
  *  filename = snake101.txt
==> passed

Test 7: Opens every site
  *  filename = input5.txt
==> passed

Test 8: Open random sites until just before system percolates,
        allowing open() to be called on a site more than once
  *  n = 3
  *  n = 5
  *  n = 10
  *  n = 10
  *  n = 20
  *  n = 20
  *  n = 50
  *  n = 50
==> passed

Test 9: Check that IndexOutOfBoundsException is thrown if (i, j) is out of bounds
  *  n = 10, (i, j) = (0, 6)
  *  n = 10, (i, j) = (12, 6)
  *  n = 10, (i, j) = (11, 6)
  *  n = 10, (i, j) = (6, 0)
     - java.lang.IndexOutOfBoundsException not thrown for open()
     - java.lang.IndexOutOfBoundsException not thrown for isOpen()
     - java.lang.IndexOutOfBoundsException not thrown for isFull()
  *  n = 10, (i, j) = (6, 12)
     - java.lang.IndexOutOfBoundsException not thrown for open()
     - java.lang.IndexOutOfBoundsException not thrown for isOpen()
     - java.lang.IndexOutOfBoundsException not thrown for isFull()
  *  n = 10, (i, j) = (6, 11)
     - java.lang.IndexOutOfBoundsException not thrown for open()
     - java.lang.IndexOutOfBoundsException not thrown for isOpen()
     - java.lang.IndexOutOfBoundsException not thrown for isFull()
==> FAILED

Test 10: Check that IllegalArgumentException is thrown if N <= 0 in constructor
  *  n = -10
     - java.lang.IllegalArgumentException not thrown
  *  n = -1
     - java.lang.IllegalArgumentException not thrown
  *  n = 0
     - java.lang.IllegalArgumentException not thrown
==> FAILED

Test 11: Create multiple Percolation objects at the same time
         (to make sure you didn't store data in static variables)
==> passed

Test 12: Open predetermined list of sites using file inputs,
         but change the order in which methods are called
  *  filename = input8.txt;  order =     isFull(),     isOpen(), percolates()
  *  filename = input8.txt;  order =     isFull(), percolates(),     isOpen()
  *  filename = input8.txt;  order =     isOpen(),     isFull(), percolates()
  *  filename = input8.txt;  order =     isOpen(), percolates(),     isFull()
  *  filename = input8.txt;  order = percolates(),     isOpen(),     isFull()
  *  filename = input8.txt;  order = percolates(),     isFull(),     isOpen()
==> passed

Test 13: Call all methods in random order until just before system percolates
  *  n = 3
  *  n = 5
  *  n = 7
  *  n = 10
  *  n = 20
  *  n = 50
==> passed

Test 14: Call all methods in random order until almost all sites are open,
         but with inputs not prone to backwash
  *  n = 3
  *  n = 5
  *  n = 7
  *  n = 10
  *  n = 20
  *  n = 50
==> passed

Test 15: Call all methods in random order until all sites are open,
         allowing isOpen() to be called on a site more than once
         (these inputs are prone to backwash)
  *  n = 3
     isFull(3, 1) returns wrong value [after 7 sites opened]
     - student   = true
     - reference = false
     - failed on trial 7 of 40
  *  n = 5
     isFull(4, 3) returns wrong value [after 17 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 20
  *  n = 7
     isFull(6, 1) returns wrong value [after 35 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 10
  *  n = 10
     isFull(8, 6) returns wrong value [after 47 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 5
  *  n = 20
     isFull(17, 12) returns wrong value [after 219 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 2
  *  n = 50
     isFull(15, 31) returns wrong value [after 1532 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 1
==> FAILED


Total: 10/15 tests passed!


================================================================

******************************************************************************
*          executing (substituting reference Percolation.java)
******************************************************************************

Testing methods in PercolationStats
*-----------------------------------------------------------
Running 11 total tests.

Test 1: Test that PercolationStats creates trials Percolation objects, each of size n-by-n
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 2: Test that PercolationStats calls open() until system percolates
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 3: Test that PercolationStats does not call open() after system percolates
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 4: Test that mean() is consistent with the number of intercepted calls to open()
        on blocked sites
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 5: Test that stddev() is consistent with the number of intercepted calls to open()
        on blocked sites
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 6: Test that confidenceLo() and confidenceHigh() are consistent with mean() and stddev()
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 7: Check whether exception is thrown if either n or trials is out of bounds
  * n = -23, trials =  42
  - java.lang.IllegalArgumentException not thrown for PercolationStats()
  * n =  23, trials =   0
  - java.lang.IllegalArgumentException not thrown for PercolationStats()
  * n = -42, trials =   0
  - java.lang.IllegalArgumentException not thrown for PercolationStats()
  * n =  42, trials =  -1
  - java.lang.IllegalArgumentException not thrown for PercolationStats()
==> FAILED

Test 8: Create two PercolationStats objects at the same time and check mean()
        (to make sure you didn't store data in static variables)
  * n1 =  50, trials1 =  10, n2 =  50, trials2 =   5
  * n1 =  50, trials1 =   5, n2 =  50, trials2 =  10
  * n1 =  50, trials1 =  10, n2 =  25, trials2 =  10
  * n1 =  25, trials1 =  10, n2 =  50, trials2 =  10
  * n1 =  50, trials1 =  10, n2 =  15, trials2 = 100
  * n1 =  15, trials1 = 100, n2 =  50, trials2 =  10
==> passed

Test 9: Check that the methods return the same value, regardless of
        the order in which they are called
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 10: Check for any calls to StdRandom.setSeed()
  * n = 20, trials = 10
  * n = 20, trials = 10
  * n = 40, trials = 10
  * n = 80, trials = 10
==> passed

Test 11: Check distribution of number of sites opened until percolation
  * n = 2, trials = 100000
  * n = 3, trials = 100000
                           3     4     5     6     7 
                       -----------------------------
    observed frequency  3561 12495 28367 34062 21515   100000
    expected frequency  3571 13889 29365 32937 20238   100000
    
    chi-square = 292.86 (p-value = 0.000000, reject if p-value <= 0.0001)

     Note: a correct solution will fail this test by bad luck 1 time in 10000.

  * n = 4, trials = 100000
                           4     5     6     7     8     9    10    11    12    13 
                       -----------------------------------------------------------
    observed frequency   218   991  3101  7219 13019 19534 21867 18686 11341  4024   100000
    expected frequency   220  1154  3497  7822 13850 19542 21522 17924 10733  3736   100000
    
    chi-square = 258.80 (p-value = 0.000000, reject if p-value <= 0.0001)

     Note: a correct solution will fail this test by bad luck 1 time in 10000.

==> FAILED


Total: 9/11 tests passed!


================================================================

******************************************************************************
*          memory (substituting reference Percolation.java)
******************************************************************************

Computing memory of PercolationStats
*-----------------------------------------------------------
Running 4 total tests.

Test 1a-1d: Memory usage as a function of trials for n = 100
            (max allowed: 8*trials + 128 bytes)

            trials        bytes
--------------------------------------------
=> passed       16          176         
=> passed       32          304         
=> passed       64          560         
=> passed      128         1072         
==> 4/4 tests passed


Estimated student memory = 8.00 T + 48.00   (R^2 = 1.000)

Total: 4/4 tests passed!

================================================================



******************************************************************************
*          MEMORY
******************************************************************************

Computing memory of Percolation
*-----------------------------------------------------------
Running 4 total tests.

Test 1a-1d: Check that total memory <= 17 n^2 + 128 n + 1024 bytes

                 n        bytes
--------------------------------------------
=> passed       64        37040         
=> passed      256       590000         
=> passed      512      2359472         
=> passed     1024      9437360         
==> 4/4 tests passed


Estimated student memory = 9.00 n^2 + 0.00 n + 176.00   (R^2 = 1.000)


Test 2 (bonus): Check that total memory <= 11 n^2 + 128 n + 1024 bytes
   -  bonus available only if solution passes backwash correctness test
==> FAILED


Total: 4/4 tests passed!

================================================================



******************************************************************************
*          TIMING
******************************************************************************

Timing Percolation
*-----------------------------------------------------------
Running 9 total tests.

Test 1a-1e: Create an n-by-n percolation system; open sites at random until
            the system percolates. Count calls to connected(), union() and
            find() in WeightedQuickUnionUF.
                                                 2 * connected()
                 n   seconds       union()              + find()        constructor
---------------------------------------------------------------------------------------------
=> passed        8     0.00           66                   250                   1         
=> passed       32     0.00          760                  3092                   1         
=> passed      128     0.01        11294                 48006                   1         
=> passed      512     0.04       185343                785726                   1         
=> passed     1024     0.11       728916               3100964                   1         
==> 5/5 tests passed

Running time in seconds depends on the machine on which the script runs,
and  varies each time that you submit. If one of the values in the table
violates the performance limits, the factor by which you failed the test
appears in parentheses. For example, (9.6x) in the union() column
indicates that it uses 9.6x too many calls.


Tests 2a-2d: Check whether number of calls to union(), connected(), and find()
             is a constant per call to open(), isFull(), and percolates().
             The table shows the maximum number of union(), connected(), and
             find() calls made during a single call to open(), isFull(), and
             percolates().

                 n     per open()      per isOpen()    per isFull()    per percolates() 
---------------------------------------------------------------------------------------------
=> passed       32        4               0               1               1         
=> passed      128        4               0               1               1         
=> passed      512        4               0               1               1         
=> passed     1024        4               0               1               1         
==> 4/4 tests passed

Total: 9/9 tests passed!
================================================================