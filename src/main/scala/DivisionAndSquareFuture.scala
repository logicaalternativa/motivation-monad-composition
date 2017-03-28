package motivationcompositionmonad

import scala.util.{Try, Success, Failure}
import scala.concurrent.Future 

object DivisionAndSquareFuture extends DivisionAndSquare[Future] {
  
  import scala.concurrent.ExecutionContext.Implicits.global
  
  import scala.util.Random.nextInt
  
  def division( divident : Int, divisor : Int ) : Future[Int] = {
        
        divisor match {
        
          case 0 => 
            Future {
                Thread.sleep( nextInt( 5 ) *100 )
                throw new IllegalArgumentException( "Error divisor equals 0" ) 
            }  
          case value => 
            Future {
                Thread.sleep( nextInt( 5 ) *100 )
                divident/value
            }
          
        }
      
    }
    
    def square( value : Int ) : Future[Double] = {
      
      import scala.math.sqrt
      
      if( value < 0){
      
        Future{
          Thread.sleep( nextInt( 5 ) *100 )
          throw new IllegalArgumentException( "Error value minus 0" )         
        }
              
      }else{
        
        Future {
          Thread.sleep( nextInt( 5 ) *100 )
          sqrt(value)
        }
        
      }
       
    }
  

    override def divisionAndSquare( divident : Int, divisor : Int ) : Future[Double] = {


       for {
       
          resDivision <- division(divident,divisor)  
                  
          resSquare <- square(resDivision)            
       
       } yield resSquare
       
                 
    }
  
}
