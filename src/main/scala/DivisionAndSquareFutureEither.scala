package motivationcompositionmonad

import scala.util.{Try, Success, Failure}
import scala.concurrent.Future 

object Types{

  type  FutureEither[T] = Future[Either[Throwable,T]]
  
}

import Types.FutureEither

object DivisionAndSquareFutureEither extends DivisionAndSquare[FutureEither] {
  
  import scala.concurrent.ExecutionContext.Implicits.global
  
  import scala.util.Random.nextInt
  
    def division( divident : Int, divisor : Int ) : FutureEither[Int] = {
        
        divisor match {
        
          case 0 => 
            Future {
                Thread.sleep( nextInt( 5 ) *100 )
                Left( new IllegalArgumentException( "Error divisor equals 0" ) )
            }  
          case value => 
            Future {
                Thread.sleep( nextInt( 5 ) *100 )
                Right( divident/value )
            }
          
        }
      
    }
    
    def square( value : Int ) : FutureEither[Double] = {
      
      import scala.math.sqrt
      
      if( value < 0){
      
        Future{
          Thread.sleep( nextInt( 5 ) *100 )
          Left( new IllegalArgumentException( "Error value minus 0" ))         
        }
              
      }else{
        
        Future {
          Thread.sleep( nextInt( 5 ) *100 )
          Right( sqrt( value ))
        }
        
      }
       
    }
  

    override def divisionAndSquare( divident : Int, divisor : Int ) : FutureEither[Double] = {


       for {
       
          resDivision <- division(divident,divisor)  
                  
          resSquare <-  resDivision match {
                          case Right( value ) => square( value )            
                          case Left ( error ) => Future( Left( error) )  
                        }
       
       } yield resSquare
                 
    }
  
}
