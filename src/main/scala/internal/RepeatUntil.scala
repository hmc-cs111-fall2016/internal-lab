package internal

/**
 * the loop body should execute 10 times and print:
 * 0
 * 2
 * 4
 * 6
 * 8
 */

object RepeatUntil extends App {
  
  class RepeatClass(body: ⇒Unit) {
    def until(condition: ⇒Boolean) = {
      do {
        body
      } while(!condition)
    }
  }
  
  def repeat(body: ⇒Unit) = new RepeatClass(body)
  
  /** 
   *  Alternative definition, using a new feature -- implicit classes --
   *  that was recently added to Scala
   */
  /*  implicit class repeat(body: ⇒Unit) {
        def until(condition: ⇒Boolean) = {
          do {
            body
          } while(!condition)
      }
  }*/

  var i = 0
  repeat  {
      if ( (i % 2) == 0 )
          println(i)
      i += 1
  } until(i > 9)      
}

