import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import dom.document
import org.scalajs.jquery.jQuery


object HelloApp extends JSApp {
  def main() {
    println("Hello World!")
    jQuery( setupUI _)
  }

  def setupUI() {
    jQuery("body").append("<p>Hello World</p>")
    jQuery("#button").click(addClickedMessage _)
  }


  def addClickedMessage() {
    jQuery("body").append("<p>Clicked, jQueryV3</p>");
  }
}
