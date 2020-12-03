package aoc_2020_dotty

import org.junit.Assert.{assertArrayEquals, assertEquals}
import org.junit.Test
import scala.language.implicitConversions
import DayThree._

class DayThreeSpec {

  val testData: List[List[Char]] =
    lines(s"""
       |..##.......
       |#...#...#..
       |.#....#..#.
       |..#.#...#.#
       |.#...##..#.
       |..#.##.....
       |.#.#.#....#
       |.#........#
       |#.##...#...
       |#...##....#
       |.#..#...#.#
       |""".stripMargin).map(_.toList).toList

  @Test def weCountTrees(): Unit =
    assertEquals(treeCounter(testData.head, 3), 1)
    
  @Test def partOneTest(): Unit =
    assertEquals(partOne(testData, 3, 1, 1, 0), 7)
  
  @Test def partTwoTest(): Unit =
    assertEquals(partTwo(testData), 336L)
}
