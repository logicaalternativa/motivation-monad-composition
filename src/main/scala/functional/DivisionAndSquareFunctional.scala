package motivationcompositionmonad
package functional

trait DivisionAndSquareFunctional[P[_]] extends DivisionAndSquare[P] {
  
  import cats.MonadError
    
  import cats.implicits._
  
  implicit val E : MonadError[P, Throwable]  
  
  def divisionAndSquareR( divident : Int, divisor : Int ) : P[Double] = {
    
    for {
       
        resDivision <- division(divident,divisor)                
        
        resSquare <- squareR(resDivision)            
     
    } yield resSquare
    
  }

}
