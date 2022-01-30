object ex6 extends App {
  import scala.io.StdIn._

  def evenOrOdd(num: Int): Boolean = num % 2 == 0

  val studentsNum = readInt()
  val studentsList: List[Int] = readLine().split(" ").map(_.toInt).toList
  def isPossible(students: List[Int], odds: List[Int] = List(), evens: List[Int] = List(), index: Int = 1): (Int, Int) = students match {
    case Nil if odds.length == 1 && evens.length == 1 => (odds.head, evens.head)
    case Nil => (-1, -1)
    case x :: xs =>
      if (odds.length > 1 || evens.length > 1) (-1, -1)
      else {
        if (!evenOrOdd(index) && evenOrOdd(x)) isPossible(xs, odds, evens :+ index, index + 1)
        else if (evenOrOdd(index) && !evenOrOdd(x)) isPossible(xs, odds :+ index, evens, index + 1)
        else isPossible(xs, odds, evens, index + 1)
      }
  }
  val res = isPossible(studentsList)
  println(res._1 + " " + res._2)
}
