object Option extends App {
  def foo(list: List[Int]): Int = list.find(x => x % 3 == 0).flatMap()
  }
  println(foo(List(1, 2, 4, 5)))
}
