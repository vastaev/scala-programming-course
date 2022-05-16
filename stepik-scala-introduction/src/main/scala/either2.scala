object either2 extends App {
  def foo(options: List[Option[Int]]): List[Int] =
    options.flatten(x => x)
  val options: List[Option[Int]] = List(Some(5), None, Some(2))
  println(foo(options))
}
