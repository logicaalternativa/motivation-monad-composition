package motivationcompositionmonad

trait DivisionAndSquare [P[_]] {
  
  def division( divident : Int, divisor : Int ) : P[Int] 
  
  def squareR( value : Int ) : P[Double]
  
  def divisionAndSquareR( divident : Int, divisor : Int ) : P[Double]

}
