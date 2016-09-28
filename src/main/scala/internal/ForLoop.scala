package internal

/**
 * the loop body should execute 10 times and print:
 * 0
 * 2
 * 4
 * 6
 * 8
 */

object ForLoop extends App {

  def for_loop(initializer: ⇒Unit)(condition: ⇒Boolean)(increment: ⇒Unit)(body: ⇒Unit) = {
    initializer
    while (condition) {
      body
      increment
    }
  }
  
  var i = 0;
  for_loop(i = 0)(i < 10)(i += 2) {
    println(i);
  }

}
