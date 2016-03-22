package alg

import scala.collection.mutable

class Queue[T] extends Iterable[T] {

  val values = new mutable.ListBuffer[T]()

  def this( vs : T*) {
    this()
    values ++= vs;
  }

  def enqueue(v : T) {
    values += v;
  }

  def dequeue() : T  = {
    values.remove(0)
  }

  override def iterator = values.iterator 

  override def isEmpty = values.isEmpty

  override def size = values.size
}

object Queue {

  def apply[T]( vs : T*) = {
    new Queue(vs : _*)
  }
}
