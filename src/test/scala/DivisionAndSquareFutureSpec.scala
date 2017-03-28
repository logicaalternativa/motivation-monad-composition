package motivationcompositionmonad

import org.scalatest._
import org.scalatest.concurrent.ScalaFutures


class DivisionAndSquareFutureSpec extends FunSuite with ScalaFutures {
  
  import DivisionAndSquareFuture._
  import scala.util.{Try, Success, Failure}
  import scala.concurrent.Future
  import org.scalatest.time.Span
  import org.scalatest.time.Seconds 
  
  val tm = timeout( Span( 5, Seconds ) )
  
  test("Test ok") {
    
    
    whenReady( divisionAndSquare( 8, 2 ), tm ) {
      value => assert( value === 2, "sqr (8 / 2 ) = 2 " )
    }

  }
  
  test("Test divisor equal Zero") {

    val f = divisionAndSquare( 8, 0 ) 

    whenReady( f.failed, tm ) {
      e => assert( e.getMessage === "Error divisor equals 0" )
        
    }
    
  }
    
  test("Divisor or dividend is a negative number") {
    
    val f : Future[Double] = divisionAndSquare( 8, -2 ) 

    whenReady( f.failed, tm ) {
      e => assert( e.getMessage === "Error value minus 0")
        
    }
  
  }
  

}
