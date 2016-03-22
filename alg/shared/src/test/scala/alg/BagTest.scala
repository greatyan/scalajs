package alg

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class BagTest extends FlatSpec with Matchers
{
    "A bag" should "has constructor" in {
      val bag = Bag(1,2,3)
      bag.toString should be ("Bag(1,2,3)")
    }

    it should "has foreach" in {
      val bag = Bag(1,2,3)
      val sb = new StringBuffer
      bag.foreach ( sb.append(_))
      sb.toString should be ("123")
    }
}
