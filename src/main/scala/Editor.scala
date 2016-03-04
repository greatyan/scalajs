import com.scalawarrior.scalajs.ace._
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.Dynamic.{global=>g}
import org.scalajs.jquery.jQuery
import scala.scalajs.js.JSApp

object EditorApp extends JSApp {

  val editor = new AceEditor("editor");

  def main() {

    jQuery("#submit").click( submit _);

  }

  def submit() {
    g.alert( editor.text)
  }
}

class AceEditor(val id:String) {

  val editor = ace.edit("editor")
  editor.setTheme("ace/theme/monokai")
  editor.getSession().setMode("ace/mode/scala")

  def text : String = editor.getValue()
  def text_= ( text:String) {
    editor.setValue(text);
  }

}
