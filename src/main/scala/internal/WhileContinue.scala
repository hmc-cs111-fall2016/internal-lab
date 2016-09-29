package internal

/**
 * the loop body should execute 10 times and print:
 * 0
 * 2
 * 4
 * 6
 * 8
 */

class ContinueException extends RuntimeException

object WhileContinue extends App {

  def continue = throw new ContinueException

  def while_c(cond: =>Boolean)(body: =>Unit) = while(cond) {
    try {
      body
    } catch {
      case e: ContinueException => {}
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
