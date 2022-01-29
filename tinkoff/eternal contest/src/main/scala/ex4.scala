import scala.io.StdIn._

object ex4 extends App {
  
  def `посчитать разряд без 9`(n: Int): Int =
    n.toString.dropWhile(_ == 9).length

  def only9(n: Int): Boolean =
    !n.toString.exists(_ != '9')

  def sortNumbers(numbers: List[Int]): List[Int] =
    numbers.sortWith { (left, right) =>
      // true перемещаем
      val swap = true

      if (only9(left)) !swap
      else if (only9(right)) swap
      else {
        if (`посчитать разряд без 9`(left) > `посчитать разряд без 9`(right)) swap
        else if (`посчитать разряд без 9`(left) == `посчитать разряд без 9`(right)) {
          left < right
        }
        else !swap
      }
    }

  def join(next: List[Char], acc: List[Char], n: Int): String =
    acc.mkString("") + '9' + next.mkString("")

  def pow10(p: Int, acc: Int = 1): Int = p match {
    case 0 => acc
    case _ => pow10(p - 1, acc * 10)
  }

  def replaceN(number: List[Char], acc: List[Char] = List.empty, diff: Int = 0): (String, Int) = number match {
    case Nil => (acc.mkString(""), 0)
    case ::(head, next) =>
      val n: Int = head.toInt - '0'.toInt
      if (n == 9) replaceN(next, head +: acc, diff)
      else (join(next, acc, n), (9 - n) * pow10(next.length))
  }

  def replaceNums(numbers: List[Int]): (List[Int], Int) = {
    val (newNumber, diff) = replaceN(numbers.head.toString.toList)
    (newNumber.toInt +: numbers.tail, diff)
  }

  def program(k: Int, numbers: List[Int], acc: Int = 0): Int = k match {
    case 0 => acc
    case _ =>
      val sorted: List[Int] = sortNumbers(numbers)
      val (replacedNumbers, diff) = replaceNums(sorted)
      program(k - 1, replacedNumbers, diff + acc)
  }
  val Array(n, t) = readLine().split(" ").map(_.toInt)
  val nums = readLine().split(" ").map(_.toInt).toList
  println(program(t, nums))
}
