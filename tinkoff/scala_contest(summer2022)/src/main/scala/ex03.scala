import scala.io.StdIn.readLine

object ex03 extends App {
  val input = readLine()
  val finalNum = input.reverse.dropWhile(_ == '0').reverse
  println(finalNum.count(_ == '0'))
}
