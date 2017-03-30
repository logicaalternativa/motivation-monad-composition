package motivationcompositionmonad

import org.scalatest._

class DivisionAndSquareOptionSpec extends FunSuite {
  
  import DivisionAndSquareOption._
  
  test("Test ok") {
    
    divisionAndSquareR( 8, 2 ) match {
    
      case Some( value ) => assert( value === 2, "sqr (8 / 2 ) = 2 " )
      case _ => fail( "Error!!!!" )
    } 
    
  }
  
  test("Test divisor equal Zero") {
    
    divisionAndSquareR( 8, 0 ) match {
    
      case Some( value ) => fail( s"Error. It has value: $value" )
      case _ => assert( true )
      
    }
  }
    
  test("Divisor or dividend is a negative number") {
    
    divisionAndSquareR( 8, -2 ) match {
    
      case Some( value ) => fail( s"Error. It has value: $value" )
      case _ => assert( true )
      
    }
  
  }
  

}
