package alg

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class BagTest extends FlatSpec with Matchers
{
    "A bag" should "has constructor" in {
      val bag = Bag(1,2,3)
      bag.toString should be ("Bag(1, 2, 3)")
    }

    it should "has API foreach" in {
      val bag = Bag(1,2,3)
      val sb = new StringBuffer
      bag.foreach ( sb.append(_))
      sb.toString should be ("123")
    }

    it should "has API add" in {
      val bag = new Bag[Int]()
      bag.add(1)
      bag.add(2)
      bag.toString should be ("Bag(1, 2)")
    }

    it should "has API isEmpty" in {
      val bag = new Bag[Int]()
      bag.isEmpty should be (true)
      bag.add(1)
      bag.isEmpty should be (false)
    }

    it should "has API size" in {
      val bag = new Bag[Int]()
      bag.size should be (0)
      bag.add(1)
      bag.size should be (1)
      bag.add(2)
      bag.size should be (2)
    }
}
