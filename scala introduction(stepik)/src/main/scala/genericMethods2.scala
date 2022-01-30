object genericMethods2 extends App {
  def middle[A](data: Iterable[A]): A = {
    val resIndex = data.size / 2
    data.splitAt(resIndex)._2.head
  }

  println(middle(Seq(1, 7, 5, 9)) == 5)
  println(middle("Scala") == 'a')
}
