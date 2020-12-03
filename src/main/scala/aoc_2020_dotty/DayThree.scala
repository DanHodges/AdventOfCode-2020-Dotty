package aoc_2020_dotty

object DayThree extends Day:
  
  val data = inputLines.map(_.toList).toList

  def treeCounter(l: List[Char], right: Int): Int =
    if (l(right % l.length) == '#') 1 else 0
    
  def partOne(input: List[List[Char]], right: Int, down: Int, steps: Int, count: Long): Long = 
    if (down * steps >= input.size) count else
    partOne(
      input = input,
      right = right,
      down = down,
      steps = steps + 1,
      count = count + treeCounter(input(down * steps), right * steps)
    )

  def slopes = List((1,1), (3, 1), (5,1), (7,1), (1,2))
  
  def partTwo(input: List[List[Char]]) = slopes.map {
    case (right, down) => partOne(input, right, down, steps = 1, count =  0)
  }.product
  
  override def answerOne = partOne(input = data, right = 3, down = 1, steps =  1, count = 0).toString
  override def answerTwo = partTwo(data).toString
