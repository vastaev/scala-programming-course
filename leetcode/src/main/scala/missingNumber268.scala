object missingNumber268 extends App {
  def missingNumber(nums: Array[Int]): Int = {
    val n = nums.length
    n * (n + 1) / 2 - nums.sum
  }
}
