package internal

/**
 * the loop body should execute 10 times and print:
 * 0
 * 2
 * 4
 * 6
 * 8
 */

class Repeat(body: =>Unit) {
  def until(cond: =>Boolean): Unit = {
    body
    if (!cond) {
      until(cond)
    }
  }
}

object RepeatUntil extends App {
  def repeat(body: =>Unit) = new Repeat(body)

  var i = 0
  repeat {
    if ( (i % 2) == 0 )
      println(i)
    i += 1
  } until(i > 9)
}
