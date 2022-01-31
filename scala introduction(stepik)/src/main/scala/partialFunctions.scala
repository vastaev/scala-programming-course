object partialFunctions extends App {
  val log: PartialFunction[Double, Double] = {
    case n: Double if n > 0 => Math.log(n)
  }
  val nums: List[Double] = List(1, 8, 2, -5)
  println(nums.collect(log))
}
