# Lab: Subversive Scala 

## Overview
In this lab, you'll face three puzzles. Each puzzle asks you to implement a 
new control-flow structure *for* Scala *in* Scala.

Implementing a control-flow structure is a lot like implementing a data
structure: Just as you implement a new data structure by using *pre-existing*
data structures, you implement a new control-flow structure by using pre-
existing control-flow structures.

A more detailed description is below. Here are a few notes about the control-
flow structures:

  - When solving a puzzle, reverse-engineer it from the interface (i.e., what
  the user types). Looking at this interface, what kinds of Scala structures
  (e.g., functions and methods) could be used in that way?
  - Some of the puzzles may be tricky at first. Keep at it, and talk to other
  people about your ideas. Above all, resist the temptation to look for an
  answer online or in a book. The main benefit of this lab is to start
  developing the thinking process that you'll use to implement internal DSLs.
  - The control-flow structures that you're asked to implement are very 
  un-Scala-y! Their behavior essentially relies on mutable variables, which we 
  try to avoid in traditional Scala. But, of course, this is not traditional 
  Scala. This is subversive Scala :).

Here are a few notes about the files for this lab:

  - You should follow the standard assignment workflow for the lab, so that you
  can issue a pull request to show off your work. (You'll get participation
  points for your pull request.)
  - The files are set up for you to run `sbt eclipse`, so you can work in
  ScalaIDE (though you don't *have* to do it that way).
  - Initially, the files won't compile because you haven't implemented the
  control-flow structures. You may want to comment out some of the code until
  you have a chance to implement your control-flow structure.

## Part 1: `loop_until`
Implement a control-flow structure called `loop_until` that can be used like so:

```
var i = 0 
loop_until (i > 9) {
  if ( (i % 2) == 0 ) 
    println(i)
  i += 1
}
```

The `loop_until` control structure first checks its condition. If the condition
is *false*, it executes the body. It then checks the condition again. If the
condition is still false, it again executes the body and continues in this
fashion until the condition becomes true.

In the case of the example above, the body of the `loop_until` structure should
execute 10 times and print the numbers `0`, `2`, `4`, `6`, `8` (with each number
appearing on a separate line).

Put your implementation in the file `/src/main/scala/internal/LoopUntil.scala`.

You can test your program in your IDE, or from sbt with `sbt run`.

## Part 2: `for_loop`
Implement a control-flow structure called `for_loop` that can be used like so:

```
var i = 0;
for_loop(i = 0)(i < 10)(i += 2) {
  println(i);
}
```

The `for_loop` control structure first performs the initialization (`i=0`).
Then, it checks its condition (`i < 10`). If the condition is true, it executes
the body. Then it perfoms the increment (`i += 2`). It then checks the condition
again. If the condition is still true, it again executes the body and continues
in this fashion until the condition becomes false.

In the case of the example above, the body of the `for_loop` structure should
execute 10 times and print the numbers `0`, `2`, `4`, `6`, `8` (with each number
appearing on a separate line).

Note that, unfortunately, we don't have a good way to include the variable
definition as part of the for loop. The user has to declare the variable outside
the for loop, then (re-)initialize it as part of the for loop.

Put your implementation in the file `/src/main/scala/internal/ForLoop.scala`.

## Part 3: `while_c` and `continue`
Implement control-flow structures called `while_c` and `continue` that can be 
used like so:

```
var i = -1
while_c (i < 9) {
   i += 1
   if ( (i % 2) != 0 )
      continue
   println(i)
} 
```

The `while_c` control structure first checks its condition. If the condition
is *true*, it executes the body. It then checks the condition again. If the
condition is still true, it again executes the body and continues in this
fashion until the condition becomes false.

The `continue` control structure, when it appears inside a `while_c`, causes the
program to jump directly to the top of that loop, where it will check the loop
condition again and continue on like normal.

If `continue` appears outside a `while_c` loop, its behavior is undefined. So, 
in your implementation, you don't need to check whether `continue` appears
inside `while_c`. You only need to make the program behave properly in the case
when a `while_c` contains a `continue`.

In the example above, the body of the `while_c` structure should
execute 10 times and print the numbers `0`, `2`, `4`, `6`, `8` (with each number
appearing on a separate line).

Put your implementation in the file 
`/src/main/scala/internal/WhileContinue.scala`.

## Part 4: `repeat` … `until`
Implement a control-flow structure called `repeat` … `until` that can be used 
like so:

```
var i = 0
repeat {
   if ( (i % 2) == 0 )
      println(i)
   i += 1
} until (i > 9)
```

The `repeat` … `until` control structure first executes its body. Then it checks
its condition. If the condition is *false*, it executes the body again. It then
checks the condition again and continues in this fashion until the condition
becomes true.

In the case of the example above, the body of the `repeat` … `until` structure
should execute 10 times and print the numbers `0`, `2`, `4`, `6`, `8` (with each
number appearing on a separate line).

Put your implementation in the file 
`/src/main/scala/internal/RepeatUntil.scala`.

## Bonus: Summations
If you finish the first three parts of the lab, consider taking on this
challenge: Design and implement a notation for mathematical summations that is as
expressive as those used in math and is as close as possible to the notation that
a mathematician would use.

## Bonus: ScalaTest
Take a look at the 
[ScalaTest guide](http://www.scalatest.org/user_guide/selecting_a_style), 
which describes a dizzying array of options for specifying tests. See if you can 
reverse-engineer their implementation: how are the implementers of ScalaTest 
providing all these options? Check whether your intuition is correct by browsing
the ScalaTest 
[documentation](http://doc.scalatest.org/2.2.4/index.html#org.scalatest.FlatSpec) or
[source code](https://github.com/scalatest/scalatest/tree/master/scalatest/src/main/scala/org/scalatest).

_Note: ScalaTest is a big library that provides many forms of syntactic sugar 
for what is essentially the same behavior. As such, there's more software engineering
in ScalaTest that there is in your implementation of control-flow structures!_

## Bonus: Baysick
Try your hand at implementing the syntax for
[Baysick](https://github.com/fogus/baysick), an internal DSL that mimics the
[Basic](http://en.wikipedia.org/wiki/BASIC) programming language. (Don't look at
the implementation online; reverse engineer it from the examples!)
