object generics2 extends App {
  case class Pair[T](first: T, second: T)(implicit ord: Ordering[T]) {
    import ord.mkOrderingOps
    def smaller =
      if (first < second) first
      else second
  }

  val p = Pair(BigInt("1000000000000000"),BigInt("7000000000000000"))
  require(p.smaller == BigInt("1000000000000000"))
}
