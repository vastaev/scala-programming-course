object option extends App {
  def foo(list: List[Int]): Int = list.find(x => x % 3 == 0) match {
    case None => 0
    case Some(x) => x * 2
  }
  println(foo(List(1, 2, 4, 5)))
}
