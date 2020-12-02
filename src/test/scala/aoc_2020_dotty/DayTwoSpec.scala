package aoc_2020_dotty

import aoc_2020_dotty.DayTwo._
import .DayOne
import org.junit.Assert._
import org.junit.Test
import scala.language.implicitConversions

class DayTwoSpec {
  val data =  s"""
     |1-3 a: abcde
     |1-3 b: cdefg
     |2-9 c: ccccccccc
     |""".stripMargin.split("\n").filter(_.length > 0).map(_.trim).map(PasswordEntry.apply)

  @Test def partOneTest(): Unit =
    assertEquals(partOne(data), 2)

  @Test def partTwoTest(): Unit =
    assertEquals(partTwo(data), 1)

}
