import scala.scalajs.js
import org.scalajs.dom._

/**
  * Created by rely10 on 5/17/16.
  */

object MainJS extends js.JSApp {
  def main(): Unit = {
    check1()
  }

  def check1(): Unit = {
    val checky: String = "Here we are"
    console.log(checky)

    val change: Element = document.getElementById("change")
    change.innerHTML = checky
  }
}
