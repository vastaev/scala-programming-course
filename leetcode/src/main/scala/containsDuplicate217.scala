object containsDuplicate217 extends App {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    nums.length != nums.toSet.size
  }
}
