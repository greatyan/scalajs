package alg

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class QueueTest extends FlatSpec with Matchers {

  "A Queue" should "has constructor" in {
    val queue = Queue(1,2,3)
    queue.toString should be ("Queue(1, 2, 3)");
  }

  it should "has enqueue/dequeue/isEmpty/size" in {
    val queue = new Queue[Int]()
    queue.isEmpty should be (true)
    queue.size should be (0)
    queue.enqueue(1)
    queue.isEmpty should be (false)
    queue.size should be (1)
    queue.enqueue(2)
    queue.isEmpty should be (false)
    queue.size should be (2)
    queue.dequeue() should be (1)
    queue.size should be (1)
    queue.enqueue(3)
    queue.isEmpty should be (false)
    queue.size should be (2)
    queue.dequeue() should be (2)
    queue.dequeue() should be (3)
    queue.isEmpty should be (true)
    queue.size should be (0)
  }

  it should "like Iterable" in {
    val queue = Queue(1,2,3)
    val sb = new StringBuilder
    queue.mkString(",") should be ("1,2,3")
  }
}
