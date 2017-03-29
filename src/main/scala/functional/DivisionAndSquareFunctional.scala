package motivationcompositionmonad
package functional

trait DivisionAndSquareFunctional[P[_]] extends DivisionAndSquare[P] {
  
  import cats.MonadError
    
  import cats.implicits._
  
  implicit val E : MonadError[P, Throwable]  
  
  def divisionAndSquare( divident : Int, divisor : Int ) : P[Double] = {
    
    for {
       
        resDivision <- division(divident,divisor)                
        
        resSquare <- square(resDivision)            
     
    } yield resSquare
    
  }

}
