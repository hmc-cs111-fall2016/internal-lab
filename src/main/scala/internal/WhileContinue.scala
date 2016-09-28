package internal

/**
 * the loop body should execute 10 times and print:
 * 0
 * 2
 * 4
 * 6
 * 8
 */

object WhileContinue extends App {

  object ContinueException extends Exception
  
  def continue = throw ContinueException
  
  def while_c(condition: ⇒Boolean)(body: ⇒Unit): Unit = {
    try {
      while (condition) {
        body
      }
    } catch {
      case ContinueException ⇒ while_c(condition)(body)
      case other: Exception ⇒ throw other
    }
  }

  var i = -1

  while_c (i < 9) {
      i += 1
      if ( (i % 2) != 0 )
          continue
      println(i)
  }        

}
