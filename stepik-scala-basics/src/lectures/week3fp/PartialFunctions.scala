package lectures.week3fp

object PartialFunctions extends App {
  val chatBotFunc: PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }
  val chatbot = chatBotFunc.lift

  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)
}
