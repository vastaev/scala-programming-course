import scala.io.StdIn.readLine

object ex05 extends App {
  def multipliedArraySum(nums: Array[Int]) = {
    nums.zip(1 to n).map(x => x._1 * x._2).sum
  }
  val Array(n, k) = readLine().split(" ").map(_.toInt)
  val nums = (1 to n).toArray
  val startRange = multipliedArraySum(nums.reverse)
  val endRange = multipliedArraySum(nums)
  println((endRange - startRange) / k)
}
