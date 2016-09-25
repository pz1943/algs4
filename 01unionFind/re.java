See the Assessment Guide for information on how to interpret this report.

Assessment Summary

Compilation:  PASSED
Style:        PASSED
Findbugs:     No potential bugs found.
API:          PASSED

Correctness:  2/26 tests passed
Memory:       4/8 tests passed
Timing:       0/9 tests passed

Aggregate score: 10.00% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]

Assessment Details

The following files were submitted:
----------------------------------
total 12K
-rw-r--r-- 1 2.9K Sep 15 14:25 Percolation.java
-rw-r--r-- 1 2.6K Sep 15 14:25 PercolationStats.java
-rw-r--r-- 1 2.0K Sep 15 14:25 studentSubmission.zip


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
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input8.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input8-no.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input10-no.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = greeting57.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = heart25.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
==> FAILED

Test 2: Open random sites until just before system percolates
  *  n = 3
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 5
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 10
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 10
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 20
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 20
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 50
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 50
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
==> FAILED

Test 3: Opens predetermined sites for N = 1 and N = 2 (corner case test)
  *  filename = input1.txt
     percolates() returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input1-no.txt
     percolates() returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input2.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input2-no.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
==> FAILED

Test 4: Check for backwash with predetermined sites
  *  filename = input20.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input10.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input50.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = jerry47.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
==> FAILED

Test 5: Check for backwash with predetermined sites that have
        multiple percolating paths
  *  filename = input3.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input4.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = input7.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
==> FAILED

Test 6: Predetermined sites with long percolating path
  *  filename = snake13.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
  *  filename = snake101.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
==> FAILED

Test 7: Opens every site
  *  filename = input5.txt
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed before any calls to isOpen()
==> FAILED

Test 8: Open random sites until just before system percolates,
        allowing open() to be called on a site more than once
  *  n = 3
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 5
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 10
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 10
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 20
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 20
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 50
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
  *  n = 50
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed after call 0 to isOpen()
==> FAILED

Test 9: Check that IndexOutOfBoundsException is thrown if (i, j) is out of bounds
  *  n = 10, (i, j) = (0, 6)
  *  n = 10, (i, j) = (12, 6)
  *  n = 10, (i, j) = (11, 6)
  *  n = 10, (i, j) = (6, 0)
  *  n = 10, (i, j) = (6, 12)
  *  n = 10, (i, j) = (6, 11)
==> passed

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
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
==> FAILED

Test 12: Open predetermined list of sites using file inputs,
         but change the order in which methods are called
  *  filename = input8.txt;  order =     isFull(),     isOpen(), percolates()
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
  *  filename = input8.txt;  order =     isFull(), percolates(),     isOpen()
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
  *  filename = input8.txt;  order =     isOpen(),     isFull(), percolates()
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
  *  filename = input8.txt;  order =     isOpen(), percolates(),     isFull()
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
  *  filename = input8.txt;  order = percolates(),     isOpen(),     isFull()
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
  *  filename = input8.txt;  order = percolates(),     isFull(),     isOpen()
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
==> FAILED

Test 13: Call all methods in random order until just before system percolates
  *  n = 3
     isFull(1, 1) returns wrong value [after 2 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 40
     - sequence of operations was:
         percolation.isOpen(i, j) for each i and j
         percolation.isOpen(i, j) for each i and j
         percolation.open(2, 3)
         percolation.isOpen(i, j) for each i and j
         percolation.percolates()
         percolation.open(1, 3)
         percolation.isFull(i, j) for each i and j

  *  n = 5
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 20
     - sequence of operations was:
         percolation.isFull(i, j) for each i and j

  *  n = 7
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 10
     - sequence of operations was:
         percolation.open(7, 4)
         percolation.isOpen(i, j) for each i and j
         percolation.isOpen(i, j) for each i and j
         percolation.isOpen(i, j) for each i and j
         percolation.isOpen(i, j) for each i and j
         percolation.isFull(i, j) for each i and j

  *  n = 10
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 5
     - sequence of operations was:
         percolation.isFull(i, j) for each i and j

  *  n = 20
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 2
     - sequence of operations was:
         percolation.percolates()
         percolation.percolates()
         percolation.isFull(i, j) for each i and j

  *  n = 50
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 1
     - sequence of operations was:
         percolation.percolates()
         percolation.isOpen(i, j) for each i and j
         percolation.percolates()
         percolation.isFull(i, j) for each i and j

==> passed

Test 14: Call all methods in random order until almost all sites are open,
         but with inputs not prone to backwash
  *  n = 3
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 40
  *  n = 5
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 20
  *  n = 7
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 10
  *  n = 10
     isFull(1, 1) returns wrong value [after 2 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 5
  *  n = 20
     isFull(1, 1) returns wrong value [after 3 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 2
  *  n = 50
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 1
==> FAILED

Test 15: Call all methods in random order until all sites are open,
         allowing isOpen() to be called on a site more than once
         (these inputs are prone to backwash)
  *  n = 3
     isFull(1, 1) returns wrong value [after 2 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 40
  *  n = 5
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 20
  *  n = 7
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 10
  *  n = 10
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 5
  *  n = 20
     isFull(1, 1) returns wrong value [after 1 site opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 2
  *  n = 50
     isFull(1, 1) returns wrong value [after 0 sites opened]
     - student   = true
     - reference = false
     - failed on trial 1 of 1
==> FAILED


Total: 2/15 tests passed!


================================================================

******************************************************************************
*          executing (substituting reference Percolation.java)
******************************************************************************

Testing methods in PercolationStats
*-----------------------------------------------------------
Running 11 total tests.

Test 1: Test that PercolationStats creates trials Percolation objects, each of size n-by-n
  * n =  20, trials =  10
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testGridSizes(TestPercolationStats.java:14)
     TestPercolationStats.test1(TestPercolationStats.java:438)
     TestPercolationStats.main(TestPercolationStats.java:577)

  * n =  50, trials =  20
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testGridSizes(TestPercolationStats.java:14)
     TestPercolationStats.test1(TestPercolationStats.java:439)
     TestPercolationStats.main(TestPercolationStats.java:577)

  * n = 100, trials =  50
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testGridSizes(TestPercolationStats.java:14)
     TestPercolationStats.test1(TestPercolationStats.java:440)
     TestPercolationStats.main(TestPercolationStats.java:577)

  * n =  64, trials = 150
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testGridSizes(TestPercolationStats.java:14)
     TestPercolationStats.test1(TestPercolationStats.java:441)
     TestPercolationStats.main(TestPercolationStats.java:577)

==> FAILED

Test 2: Test that PercolationStats calls open() until system percolates
  * n =  20, trials =  10
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testPercolatesBefore(TestPercolationStats.java:42)
     TestPercolationStats.test2(TestPercolationStats.java:447)
     TestPercolationStats.main(TestPercolationStats.java:580)

  * n =  50, trials =  20
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testPercolatesBefore(TestPercolationStats.java:42)
     TestPercolationStats.test2(TestPercolationStats.java:448)
     TestPercolationStats.main(TestPercolationStats.java:580)

  * n = 100, trials =  50
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testPercolatesBefore(TestPercolationStats.java:42)
     TestPercolationStats.test2(TestPercolationStats.java:449)
     TestPercolationStats.main(TestPercolationStats.java:580)

  * n =  64, trials = 150
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testPercolatesBefore(TestPercolationStats.java:42)
     TestPercolationStats.test2(TestPercolationStats.java:450)
     TestPercolationStats.main(TestPercolationStats.java:580)

==> FAILED

Test 3: Test that PercolationStats does not call open() after system percolates
  * n =  20, trials =  10
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testPercolatesAfter(TestPercolationStats.java:71)
     TestPercolationStats.test3(TestPercolationStats.java:456)
     TestPercolationStats.main(TestPercolationStats.java:582)

  * n =  50, trials =  20
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testPercolatesAfter(TestPercolationStats.java:71)
     TestPercolationStats.test3(TestPercolationStats.java:457)
     TestPercolationStats.main(TestPercolationStats.java:582)

  * n = 100, trials =  50
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testPercolatesAfter(TestPercolationStats.java:71)
     TestPercolationStats.test3(TestPercolationStats.java:458)
     TestPercolationStats.main(TestPercolationStats.java:582)

  * n =  64, trials = 150
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testPercolatesAfter(TestPercolationStats.java:71)
     TestPercolationStats.test3(TestPercolationStats.java:459)
     TestPercolationStats.main(TestPercolationStats.java:582)

==> FAILED

Test 4: Test that mean() is consistent with the number of intercepted calls to open()
        on blocked sites
  * n =  20, trials =  10
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testMean(TestPercolationStats.java:101)
     TestPercolationStats.test4(TestPercolationStats.java:466)
     TestPercolationStats.main(TestPercolationStats.java:584)

  * n =  50, trials =  20
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testMean(TestPercolationStats.java:101)
     TestPercolationStats.test4(TestPercolationStats.java:467)
     TestPercolationStats.main(TestPercolationStats.java:584)

  * n = 100, trials =  50
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testMean(TestPercolationStats.java:101)
     TestPercolationStats.test4(TestPercolationStats.java:468)
     TestPercolationStats.main(TestPercolationStats.java:584)

  * n =  64, trials = 150
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testMean(TestPercolationStats.java:101)
     TestPercolationStats.test4(TestPercolationStats.java:469)
     TestPercolationStats.main(TestPercolationStats.java:584)

==> FAILED

Test 5: Test that stddev() is consistent with the number of intercepted calls to open()
        on blocked sites
  * n =  20, trials =  10
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testStddev(TestPercolationStats.java:134)
     TestPercolationStats.test5(TestPercolationStats.java:476)
     TestPercolationStats.main(TestPercolationStats.java:586)

  * n =  50, trials =  20
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testStddev(TestPercolationStats.java:134)
     TestPercolationStats.test5(TestPercolationStats.java:477)
     TestPercolationStats.main(TestPercolationStats.java:586)

  * n = 100, trials =  50
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testStddev(TestPercolationStats.java:134)
     TestPercolationStats.test5(TestPercolationStats.java:478)
     TestPercolationStats.main(TestPercolationStats.java:586)

  * n =  64, trials = 150
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testStddev(TestPercolationStats.java:134)
     TestPercolationStats.test5(TestPercolationStats.java:479)
     TestPercolationStats.main(TestPercolationStats.java:586)

==> FAILED

Test 6: Test that confidenceLo() and confidenceHigh() are consistent with mean() and stddev()
  * n =  20, trials =  10
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testConfidence(TestPercolationStats.java:169)
     TestPercolationStats.test6(TestPercolationStats.java:485)
     TestPercolationStats.main(TestPercolationStats.java:588)

  * n =  50, trials =  20
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testConfidence(TestPercolationStats.java:169)
     TestPercolationStats.test6(TestPercolationStats.java:486)
     TestPercolationStats.main(TestPercolationStats.java:588)

  * n = 100, trials =  50
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testConfidence(TestPercolationStats.java:169)
     TestPercolationStats.test6(TestPercolationStats.java:487)
     TestPercolationStats.main(TestPercolationStats.java:588)

  * n =  64, trials = 150
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.testConfidence(TestPercolationStats.java:169)
     TestPercolationStats.test6(TestPercolationStats.java:488)
     TestPercolationStats.main(TestPercolationStats.java:588)

==> FAILED

Test 7: Check whether exception is thrown if either n or trials is out of bounds
  * n = -23, trials =  42
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
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.twoPercolationStats(TestPercolationStats.java:219)
     TestPercolationStats.test8(TestPercolationStats.java:506)
     TestPercolationStats.main(TestPercolationStats.java:592)

  * n1 =  50, trials1 =   5, n2 =  50, trials2 =  10
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.twoPercolationStats(TestPercolationStats.java:219)
     TestPercolationStats.test8(TestPercolationStats.java:507)
     TestPercolationStats.main(TestPercolationStats.java:592)

  * n1 =  50, trials1 =  10, n2 =  25, trials2 =  10
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.twoPercolationStats(TestPercolationStats.java:219)
     TestPercolationStats.test8(TestPercolationStats.java:508)
     TestPercolationStats.main(TestPercolationStats.java:592)

  * n1 =  25, trials1 =  10, n2 =  50, trials2 =  10
     java.lang.IndexOutOfBoundsException: Row index i out of bounds: 0

     Percolation.validate(Percolation.java:129)
     Percolation.isOpen(Percolation.java:147)
     PercolationStats.<init>(PercolationStats.java:20)
     TestPercolationStats.twoPercolationStats(TestPercolationStats.java:219)
     TestPercolationStats.test8(TestPercolationStats.java:509)
     TestPercolationStats.main(TestPercolationStats.java:59

...

Warning: the grading output was truncated due to excessive length.
Typically, this is becasue you have a method that has an unanticipated side effect
(such as printing to standard output or throwing an exception).