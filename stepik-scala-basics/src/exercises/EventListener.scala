package exercises

abstract class Event {
  def trigger(eventName: String): Unit
}

class Listener(val eventName: String, var event: Event) {
  def register(evt: Event) { event = evt }
  def sendNotification() { event.trigger(eventName) }
}


object EventListener extends App {
  val notification: Listener = new Listener("mousedown", null)
  notification.register(
    evt = (eventName: String) => println(s"trigger $eventName event")
  )
  notification.sendNotification()
}
