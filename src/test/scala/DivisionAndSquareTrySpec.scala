package motivationcompositionmonad

import org.scalatest._

class DivisionAndSquareTrySpec extends FunSuite {
  
  import DivisionAndSquareTry._
  import scala.util.{Try, Success, Failure}
  
  test("Test ok") {
    
    divisionAndSquareR( 8, 2 ) match {
      case Success( value ) => assert( value === 2, "sqr (8 / 2 ) = 2 " )
      case Failure( e ) => fail( "Error!!!!" )
    } 
    
  }
  
  test("Test divisor equal Zero") {
    
    divisionAndSquareR( 8, 0 ) match {
    
      case Success( value ) => fail( s"Error. It has value: $value" )
      case Failure(e) => assert( e.getMessage === "Error divisor equals 0" )
      
    }
  }
    
  test("Divisor or dividend is a negative number") {
    
    divisionAndSquareR( 8, -2 ) match {
    
      case Success ( value ) => fail( s"Error. It has value: $value" )
      case Failure (e) => assert( e.getMessage === "Error value minus 0" )
      
    }
  
  }
  

}
