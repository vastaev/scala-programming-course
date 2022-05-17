import scala.io.StdIn._

object Main {
  def main(args: Array[String]) {
    val index = readInt()
    val list: List[Int] = readLine().split(" ").map(_.toInt).toList
    // возвращает число которое будет на переданном индексе в отсортированном списке
    def kOrder(list: List[Int], k: Int): Int = {
      val head +: rest = list
      val (left, right) = rest.partition(_ <= head)
      val leftLength = left.length + 1
      leftLength match {
        case x if x == k => head
        case x if x > k => kOrder(left, k)
        case _ => kOrder(right, k - leftLength)
      }
    }
    println(kOrder(list, index))
  }
}
