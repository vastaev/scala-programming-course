import scala.io.StdIn._

object ex03 extends App {
  def findX(nums: List[Long], x: Long = 1): Long = {
    def f(nums: List[Long], x: Long, tmp: Long): Long = {
      if (nums.isEmpty) x
      else {
        val newX = tmp * tmp - nums.head
        if (newX <= 0) newX
        else f(nums.tail, x, newX)
      }
    }
    val res = f(nums, x, x)
    if (res <= 0) findX(nums, x + 1)
    else res
  }
  val n = readInt()
  val numbers: List[Long] = readLine().split(" ").map(_.toLong).sortWith(_ < _).toList
  println(findX(numbers))
}
