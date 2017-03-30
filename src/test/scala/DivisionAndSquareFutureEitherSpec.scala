package motivationcompositionmonad

import org.scalatest._
import org.scalatest.concurrent.ScalaFutures


class DivisionAndSquareFutureEitherSpec extends FunSuite with ScalaFutures {
  
  import DivisionAndSquareFutureEither._
  import scala.concurrent.Future
  import org.scalatest.time.Span
  import org.scalatest.time.Seconds 
  
  val tm = timeout( Span( 5, Seconds ) )
  
  test("Test ok") {
    
    
    whenReady( divisionAndSquareR( 8, 2 ), tm ) {
      ( res : Either[Throwable,Double] ) => 
        res match {
          case Right(value) => assert( value === 2, "sqr (8 / 2 ) = 2 " )
          case Left( error ) => fail( s"It's should not be an error : $error" )
        }
        
    }

  }
  
  test("Test divisor equal Zero") {

    whenReady( divisionAndSquareR( 8, 0 ), tm ) {
      ( res : Either[Throwable,Double] ) => 
        res match {
          case Right(value) => fail( s"It's should not be an error : $value" )
          case Left( error ) => assert( error.getMessage === "Error divisor equals 0" )
        }
        
    }
    
  }
    
  test("Divisor or dividend is a negative number") {
    
    whenReady( divisionAndSquareR( 8, -2 ), tm ) {
      ( res : Either[Throwable,Double] ) => 
        res match {
          case Right(value) => fail( s"It's should not be an error : $value" )
          case Left( error ) => assert( error.getMessage === "Error value minus 0" )
        }
        
    }
  
  }

}
