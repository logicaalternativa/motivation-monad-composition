package motivationcompositionmonad

import org.scalatest._
import org.scalatest.concurrent.ScalaFutures


class DivisionAndSquareFutureEitherJavaSpec extends FunSuite with ScalaFutures {
  
  import scala.concurrent.Future
  import org.scalatest.time.Span
  import org.scalatest.time.Seconds 
  
  import impl.DivisionAndSquareFutureEitherJava
  
  val tm = timeout( Span( 5, Seconds ) )
  
  val testClass = new DivisionAndSquareFutureEitherJava
  
  test("Test ok") {
    
    whenReady( testClass.divisionAndSquareR( 8, 2 ), tm ) {
      ( res ) => 
        res match {
          case Right(value) => assert( value === 2, "sqr (8 / 2 ) = 2 " )
          case Left( error ) => fail( s"It's should not be an error : $error" )
        }
    }

  }
  
  test("Test divisor equal Zero") {

    whenReady( testClass.divisionAndSquareR( 8, 0 ), tm ) {
      ( res : Either[Throwable,Double] ) => 
        res match {
          case Right(value) => fail( s"It's should not be an error : $value" )
          case Left( error ) => assert( error.getMessage === "Error divisor equals 0" )
        }
        
    }
    
  }
   
  test("Divisor or dividend is a negative number") {
    
    whenReady( testClass.divisionAndSquareR( 8, -2 ), tm ) {
      ( res : Either[Throwable,Double] ) => 
        res match {
          case Right(value) => fail( s"It's should not be an error : $value" )
          case Left( error ) => assert( error.getMessage === "Error value minus 0" )
        }
        
    }
  
  }

}
