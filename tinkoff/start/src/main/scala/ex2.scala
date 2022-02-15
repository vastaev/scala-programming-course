import scala.io.StdIn.readInt

object ex2 extends App {
  def input(acc: List[Int] = List(), count: Int = 0): List[Int] = {
    if (count == 10) acc
    else input(acc :+ readInt(), count + 1)
  }
  val nums = List(29,
  27,
  2,
  3,
  4,
  5,
  6,
  7, 8, 9)
  val average = nums.sum / nums.length
  println(average)
  val sorted = nums.sortWith(_ > _)
  println(sorted)
  def makeAction(res: List[Int], counter: Int = 0): Int = {
    def transfusion(list: List[Int]): List[Int] = {
      if (list.length < 4 || list.head == average) list
      else {
        val listHead = list.head
        val listLast = list.last
        val forTail = average - listLast
        val fromHead = listHead - forTail
        if (fromHead >= average) transfusion(list.updated(0, fromHead).dropRight(1))
        else {
          val toAverage = listHead - average
          list.drop(1).updated(list.length - 1, toAverage + listLast)
        }
      }
    }
    if (res.head == average) counter
    else makeAction(transfusion(res), counter + 1)
  }
  println(makeAction(sorted))
}
