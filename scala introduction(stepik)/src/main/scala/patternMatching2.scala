object patternMatching2 extends App {
  val input = List("oleg oleg@email.com", "7bdaf0a1be3", "a8af118b1a2", "28d74b7a3fe")
  val name = "([a-zA-Z]+)".r
  val email = "\\w+@(\\w+\\.\\w+)".r
  val both = "([a-zA-Z]+) \\w+@(\\w+\\.\\w+)".r
  val result = input match {
    case name(login) :: email(domain) :: _ => s"$login $domain"
    case both(login, email) :: _ => s"$login $email"
    case _ => "invalid"
  }
  println(result)
}
