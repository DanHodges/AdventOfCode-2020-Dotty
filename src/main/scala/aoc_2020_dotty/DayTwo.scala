package aoc_2020_dotty

object DayTwo extends Day:
  
  case class PasswordEntry(min: Int, max: Int, char: Char, str: String)
  object PasswordEntry:
    def apply(s: String): PasswordEntry =
      val parts = s.split("\\s")
      val minMax = parts(0).split("-").map(_.toInt).toSeq
      val char = parts(1).init.charAt(0)
      val str = parts(2)
      new PasswordEntry(minMax(0), minMax(1), char, str)


  def solve(data: Array[PasswordEntry], counter: PasswordEntry => Boolean): Int = data.count(counter)
  
  def partOne(data: Array[PasswordEntry]):Int = solve(data, pwe => {
    val count = pwe.str.count(_ == pwe.char)
    count >= pwe.min && count <= pwe.max
  })

  
  def partTwo(data: Array[PasswordEntry]): Int = solve(data, pwe => {
    def atTheCorrectSpot(index: Int) = pwe.str.charAt(index - 1) == pwe.char
    atTheCorrectSpot(pwe.min) != atTheCorrectSpot(pwe.max)
  })

  override def answerOne = partOne(inputLines.map(PasswordEntry.apply).toArray).toString
  override def answerTwo = partTwo(inputLines.map(PasswordEntry.apply).toArray).toString



