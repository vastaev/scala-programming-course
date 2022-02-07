def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def isImproperFraction(p: (Int, Int)): Boolean =
    if (math.abs(p._1) >= math.abs(p._2)) true else false

  if (p._2 == 0 || q._2 == 0 || p._1 == 0 || q._1 == 0) Left("Zero divisor")
  else if (isImproperFraction(p) || isImproperFraction(q)) Left("Invalid input")
  else {
    val newP: Int = p._1 * q._2
    val newQ: Int = p._2 * q._1
    val resGcd = gcd(newP, newQ)
    val res = (newP / resGcd, newQ / resGcd)
    if (isImproperFraction(res)) Left("Improper result")
    else Right(res)
  }
}
divide(1, 0)(1, 2) == Left("Zero divisor")
divide(1, 2)(1, 0) == Left("Zero divisor")
divide(1, 2)(0, 2) == Left("Zero divisor")

divide(3, 4)(1, 10) == Left("Improper result")
divide(1, 2)(1, 2) == Left("Improper result")

divide(2, 1)(1, 7) == Left("Invalid input")
divide(1, 2)(7, 1) == Left("Invalid input")
divide(1, 1)(2, 2) == Left("Invalid input")
divide(2, 1)(3, 1) == Left("Invalid input")

divide(-1, 2)(2, 3)
divide(1, 2)(2, 3)