package motivationcompositionmonad

trait DivisionAndSquare [P[_]] {
  
  def division( divident : Int, divisor : Int ) : P[Int] 
  
  def square( value : Int ) : P[Double]
  
  def divisionAndSquare( divident : Int, divisor : Int ) : P[Double]

}
