object patternMatching extends App{
  case class Pet(name: String, says: String)
  val pet = Pet("Rexx", "0101011")

  // Ваш код
  val robotSays = "([0-1]*)".r
  val kind = pet match {
    case Pet("Rex", _) => "dog"
    case Pet(_, "meow" | "nya") => "cat"
    case Pet(_, robotSays(_)) => "robot"
    case _ => "unknown"
  }
  println(kind)
}
