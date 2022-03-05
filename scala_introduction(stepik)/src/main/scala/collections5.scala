object collections5 {
  def main(args: Array[String]) {
    val points: List[Int] = List(2, 4, 5)
    var chr1: List[Char] = List('a', 'a', 'a', 'a', 'a', 'a', 'a')
    var chr2: List[Char] = List('d', 'd', 'd', 'd', 'd', 'd', 'd')
    for (i <- points){
      val res = Iterable(chr1, chr2).map{x => x.splitAt(i)}.reduce((x, y) => (x._1 ++ y._2, y._1 ++ x._2))
      chr1 = res._1
      chr2 = res._2
    }
    println(chr1.mkString(""))
    println(chr2.mkString(""))
  }
}
