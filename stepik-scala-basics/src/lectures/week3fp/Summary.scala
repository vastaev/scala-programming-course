package lectures.week3fp

object Summary extends App {

//  val input = "9-876-543-21-09"
//  val res = input.filter(_.isDigit).foldLeft(Map.empty[Char, Int])((acc, key) => acc + (key -> (acc.getOrElse(key, 0) + 1)))

  def compare(v1: String, v2: String): Int = {
    def splitToInt(version: String) = version.split('.').map(_.toInt)

    def makeEqual(v1: String, v2: String) = {
      val nums1 = splitToInt(v1)
      val nums2 = splitToInt(v2)
      val nums1Len = nums1.length
      val nums2Len = nums2.length
      if (nums1Len == nums2Len)
        (nums1, nums2)
      else if (nums1Len > nums2Len)
        (nums1, nums2 ++ Array.fill(nums1Len - nums2Len)(0))
      else
        (nums1 ++ Array.fill(nums2Len - nums1Len)(0), nums2)
    }
    val (nums1, nums2) = makeEqual(v1, v2)
    def loop(nums1: Array[Int], nums2: Array[Int]): Int = {
      if (nums1.isEmpty) 0
      else if (nums1.head == nums2.head) loop(nums1.tail, nums2.tail)
      else if (nums1.head > nums2.head) 1
      else -1
    }
    loop(nums1, nums2)
  }
  println(compare("0.9", "1.0"))
  println(compare("4.0.0", "4.0.0.1"))
  println(compare("4.0.1", "4.0.0.1"))
}
