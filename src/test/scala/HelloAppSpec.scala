import org.scalatest._
import org.scalajs.jquery.jQuery 

class HelloAppSpec extends FlatSpec with Matchers {
  
  HelloApp.setupUI()

  "HelloApp" should "output hello world" in {
    assert(jQuery("p:contains('Hello World')").length == 1)
  }

  "Button.click" should "output Click" in {
    val button = jQuery("#button")
    button.trigger("click")
    val length = jQuery("p:contains('Clicked')").length
    assert( length == 1, "length:" + length)
  }


}
