package playground

object ScalaPlayground extends App {
  def duplicate[T](list: List[T], nDups: Int): List[T] = list.flatMap(x => x :: List.fill(nDups - 1)(x))

}
