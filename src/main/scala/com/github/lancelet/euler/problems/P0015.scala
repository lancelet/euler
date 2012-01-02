package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import scala.collection.mutable.{Map => MMap}

/** Find the number of routes from the top left of a 20x20 grid to the bottom
 *  right, without back-tracking. */
object P0015 extends EulerProblem {
  val number = 15
  override val expected = Some("137846528820")
  def solution: String = {
    
    // we compute solutions using a counting scheme (lots of reasoning not
    //  included below)
    
    // cache because f(l, v) is evaluated multiple times
    case class LV(l: Int, v: Int)
    val cache = MMap.empty[LV, Long]
    
    def f(l: Int, v: Int): Long = {
      val lv = LV(l, v)
      if (l == 1) v.toLong + 1L
      else if (cache.contains(lv)) cache(lv)
      else {
        val ret = (for (i <- 0 to v) yield f(l-1, i)).sum
        cache(lv) = ret
        ret
      }
    }
    
    def g(l: Int) = f(l, l)
    
    g(20).toString

  }
}
