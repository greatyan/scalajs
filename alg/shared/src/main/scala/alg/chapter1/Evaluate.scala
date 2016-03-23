package alg.chapter1

class Evaluate {

    import scala.collection.mutable

    val operators = new mutable.Stack[String]()
    val operands = new mutable.Stack[Double]();

    def evaluate(input : String) : Double = {
      scan(input.split(' ').toList);
      
    }

    private def scan(input : List[String]) : Double = {

      if ( input.isEmpty) {
        operands.pop
      } else {
        input.head match {
          case "(" => 
          case ")" => evaluate()
          case o if o == "+" || o == "-" || o == "*" || o == "/" || o == "sqrt" =>
            operators.push(o)
          case v =>
            operands.push( v.toDouble)
        }
        scan(input.tail)
      }
    }

    private def evaluate() {
      operators.pop() match {
        case "+" =>
          val val2 = operands.pop();
          val val1 = operands.pop();
          operands.push( val1 + val2);
        case "-" =>
          val val2 = operands.pop();
          val val1 = operands.pop();
          operands.push( val1 - val2);
        case "*" =>
          val val2 = operands.pop();
          val val1 = operands.pop();
          operands.push( val1 * val2);
        case "/" =>
          val val2 = operands.pop();
          val val1 = operands.pop();
          operands.push( val1 / val2);
        case "sqrt" =>
          val val1 = operands.pop();
          operands.push( Math.sqrt(val1))
        case other =>
          assert(false, "Not supported operator" + other)
      }
    }
}
