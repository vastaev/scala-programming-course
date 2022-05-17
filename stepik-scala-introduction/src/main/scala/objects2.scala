object objects2 {
  import scala.io.StdIn
  import scala.util.matching.Regex

  object FacedString {
    def apply(input: String) = s"*_*$input*_*"

    def unapply(arg: String): Option[String] = {
      val regx: Regex = """\*_\*(.*)\*_\*""".r
      arg match {
        case regx(arg) => Some(arg)
        case _ => None
      }
    }
  }

  def main(args: Array[String]) {
    StdIn.readLine() match {
      case FacedString(str) => println(str)
      case _ => println("Could not recognize string")
    }
  }
}
