package internal

/**
 * the loop body should execute 5 times and print:
 * 0
 * 2
 * 4
 * 6
 * 8
 */

object ForLoop extends App {

  // define the new control-flow structure here 
  def for_loop(init: => Unit)(cond: => Boolean)(inc: => Unit)(body: => Unit) {
  	init
  	while (cond) {
  		body
  		inc
  	}
  }
  var i = 0;
  for_loop(i = 0)(i < 10)(i += 2) {
    println(i);
  }

}
