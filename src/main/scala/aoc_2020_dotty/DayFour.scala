package aoc_2020_dotty

import scala.util.Try

object DayFour extends Day:
  def data(input: String): Seq[Map[String, String]] =
    input.split("\\n\\n").toSeq.filterNot(_.isEmpty)
      .map(_.split("\\s+")
      .map(_.split(":"))
      .filter(_.size == 2)
      .map(arr => arr(0) -> arr(1)).toMap)
  
  case class Passport(byr: String,
                      iyr: String,
                      eyr: String,
                      hgt: String,
                      hcl: String,
                      ecl: String,
                      pid: String,
                      cid: Option[String]):
    
    def validByr: Boolean = byr.intCheck(_.isWithin(1920, 2002))
    
    def validIyr: Boolean = iyr.intCheck(_.isWithin(2010, 2020))
    
    def validEyr: Boolean = eyr.intCheck(_.isWithin(2020, 2030))
    
    def validHgt: Boolean = (hgt.dropRight(2), hgt.takeRight(2)) match
      case (height, "cm") => height.intCheck(_.isWithin(150, 193))
      case (height, "in") => height.intCheck(_.isWithin(59, 76))
      case _ => false
    
    def validHcl: Boolean = hcl.toList match
      case head :: tail if head == '#' && tail.size == 6 => tail.toSet.subsetOf("0123456789abcdef".toSet)
      case _ => false
    
    def validEcl = Set("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(ecl)
    
    def validPid = pid.size == 9 && pid.intCheck(x => true)
    
    def isValid: Boolean = Seq(validByr, validIyr, validEyr, validHgt, validHcl, validEcl, validPid).forall(identity)
  
  object Passport:
    def apply(m: Map[String, String]): Option[Passport] =
      Try {
        Some(new Passport(
          byr = m("byr"),
          iyr = m("iyr"),
          eyr = m("eyr"),
          hgt = m("hgt"),
          hcl = m("hcl"),
          ecl = m("ecl"),
          pid = m("pid"),
          cid = m.get("cid"),
        ))
      }.getOrElse(None)
      
  implicit class RichInt(val i: Int):
    def isWithin(a: Int, b: Int) = i >= a && i <= b
  
  implicit class RichString(val s: String):
    def intCheck(condition: Int => Boolean): Boolean =
      Try { condition(s.toInt) }.getOrElse(false)
    
  def partOne(s: String): Int =
    data(s).flatMap(Passport.apply).size
    
  def partTwo(s: String): Int =
    data(s).flatMap(Passport.apply).filter(_.isValid).size

  override def answerOne = partOne(input).toString
  
  override def answerTwo = partTwo(input).toString
