package alg.chapter1

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class EvaluateTest extends FlatSpec with Matchers
{
  "Evaluate" should "return correctly" in {
    val e = new Evaluate()
    e.evaluate("( ( ( 1 + 2 ) * ( 4 - 3 ) ) / 3 )") should be (1.0)
    e.evaluate("( sqrt 1 )") should be (1.0)
  }
}
