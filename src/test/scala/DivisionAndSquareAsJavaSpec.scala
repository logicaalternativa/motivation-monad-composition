package motivationcompositionmonad

import org.scalatest._

class DivisionAndSquareAsJavaSpec extends FunSuite {
  
  import DivisionAndSquareAsJava._
  
  test("Test ok") {
    
    assert( divisionAndSquare( 8, 2 )  === 2 )
    
  }
  
  test("Test divisor equal Zero") {
    
     
    val res = intercept[IllegalArgumentException] {
      divisionAndSquare( 8, 0 )
    }
    
    assert ( res.getMessage === "Error divisor equals 0" ) 
    
    
  }
    
  test("Divisor or dividend is a negative number") {
    
    val res = intercept[IllegalArgumentException] {
      divisionAndSquare( 8, -2 )
    }
    
    assert ( res.getMessage === "Error value minus 0" ) 
  
  }
  

}
