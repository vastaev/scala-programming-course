object abstractClasses extends App {
  trait StringProcessor {
    def process(input: String): String
  }
  val tokenDeleter = new StringProcessor {
    override def process(input: String): String = input.replaceAll("[,:;]", "")
  }

  val shortener = new StringProcessor {
    override def process(input: String): String = if (input.lengthCompare(20) > 0) input.take(20) + "..." else input
  }

  val toLowerConvertor = new StringProcessor {
    override def process(input: String): String = input.toLowerCase()
  }
}
