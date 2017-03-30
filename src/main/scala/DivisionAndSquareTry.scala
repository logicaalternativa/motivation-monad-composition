package motivationcompositionmonad

import scala.util.{Try, Success, Failure}

object DivisionAndSquareTry  extends DivisionAndSquare[Try] {
  
    def division( divident : Int, divisor : Int ) : Try[Int] = {
        
        divisor match {
        
          case 0 => Failure( new IllegalArgumentException( "Error divisor equals 0" ) )
          case value => Success( divident / value)  
           
        }
        
      
    }
    
    def squareR( value : Int ) : Try[Double] = {
      
      import scala.math.sqrt
      
      if( value < 0){
      
        Failure ( new IllegalArgumentException( "Error value minus 0" ) ) 
        
      }else{
      
         Success(sqrt(value)) 
        
      }
      
       
    }
  

    override def divisionAndSquareR( divident : Int, divisor : Int ) : Try[Double] = {

       for {
       
          resDivision <- division(divident,divisor)  
                  
          resSquare <- squareR(resDivision)            
       
       } yield resSquare
                 
    }
  
}
