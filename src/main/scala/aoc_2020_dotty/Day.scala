package aoc_2020_dotty

import scala.io.Source

trait Day:
  self =>
  def aintGottaDolla = self.getClass.getSimpleName.split("\\$").last
  def input:String = Source.fromResource(s"$aintGottaDolla.txt").mkString
  def lines(s:String = input):Seq[String] = Source.fromString(s).getLines().toSeq
  
  def inputLines = lines(input)

  def answerOne: String = "Not solved yet"
  def answerTwo: String = "Not solved yet"

  def print: Unit = println(s"\n${aintGottaDolla}\nA.) $answerOne\nB.) $answerTwo")

