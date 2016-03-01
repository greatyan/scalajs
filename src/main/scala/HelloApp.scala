import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import dom.document

object HelloApp extends JSApp {
  def main() : Unit = {
    println("Hello World!")
    appendPar(document.body, "Hello World");
  }

  def appendPar(targetNode: dom.Node, text: String) {
      val parNode = document.createElement("p");
      val textNode = document.createTextNode(text);
      parNode.appendChild( textNode);
      targetNode.appendChild(parNode);
  }

  @JSExport
  def addClickedMessage() {
    appendPar(document.body, "Clicked");
  }
}
