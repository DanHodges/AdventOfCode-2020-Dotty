package aoc_2020_dotty

import aoc_2020_dotty.DayOne._
import .DayOne
import org.junit.Assert._
import org.junit.Test

class DayOneSpec:
  val nums  = List(1721,979, 366,299,675,1456)

  @Test def partOneTest(): Unit = 
    assertEquals(partOne(nums), Some(514579))
  
  
  @Test def partTwoTest(): Unit = 
    assertEquals(partTwo(nums), Some(241861950))
  