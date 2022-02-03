object tuples extends App {
  def swap3(tuple: (Int, Int, Int)): (Int, Int, Int) = tuple match {
    case (a, b, c) => (c, b, a)
  }
  val trio = (1, 2, 3)
  println(swap3(trio))
}
