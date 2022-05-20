package lectures.week2oop

object ObjectsOOP extends App {
  class PersonalAccount

  class BusinessAccount


  class Branch {
    def openAccount(accountType: String) = {
      Account(accountType)
    }
  }

  object Account {
    def apply(accountType: String): Object = {
      if (accountType == "business") new BusinessAccount
      else new PersonalAccount
    }
  }

  val branch = new Branch()
  val account = branch.openAccount("business")
}
