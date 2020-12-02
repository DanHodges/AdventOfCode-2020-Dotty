package aoc_2020_dotty

object DayOne extends Day:
  def partOne(l: List[Int]): Option[Int] = l match {
    case Nil => None
    case head :: tail => tail.find(i => head + i == 2020).map(_ * head).orElse(partOne(tail))
  }

  def partTwo(l: List[Int]): Option[Int] = l.combinations(3).find(set => set.size == 3 && set.sum == 2020).map(_.product)
  
  override def answerOne = partOne(inputLines.map(_.toInt).toList).map(_.toString).getOrElse("unsolvable")
  override def answerTwo = partTwo(inputLines.map(_.toInt).toList).map(_.toString).getOrElse("unsolvable")
