object ex04 extends App {
  val n = 5
  val matrix = Array.ofDim[Char](n, n)

  for (i <- 0 until  n / 2) {
    val character = ('a' + i).toChar
    for (j <- 0 until n / 2) {
      matrix(i)(j) = character
    }
  }
  //  for (i <- 0 until n)
//    matrix(i)(n - 1 - i) = 'a'
//  print(matrix.map(_.mkString(" ")).mkString("\n"))
  matrix.foreach( x => println(x.mkString(" ")) )
}