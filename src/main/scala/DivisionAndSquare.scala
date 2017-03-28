package motivationcompositionmonad

trait DivisionAndSquare [P[_]] {
  
  def divisionAndSquare( divident : Int, divisor : Int ) : P[Double]

}
