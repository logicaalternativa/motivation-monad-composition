package motivationcompositionmonad

import org.scalatest._
import impl.DivisionAndSquareJava

class DivisionAndSquareAsJavaSpec extends FunSuite {
  
  import DivisionAndSquareAsJava._
  
  test("Test ok") {
    
    assert( divisionAndSquareR( 8, 2 )  === 2 )
    
  }
  
  test("Test divisor equal Zero") {
    
     
    val res = intercept[IllegalArgumentException] {
       divisionAndSquareR( 8, 0 )
    }
    
    assert ( res.getMessage === "Error divisor equals 0" ) 
    
    
  }
    
  test("Divisor or dividend is a negative number") {
    
    val res = intercept[IllegalArgumentException] {
       divisionAndSquareR( 8, -2 )
    }
    
    assert ( res.getMessage === "Error value minus 0" ) 
  
  }
  

}
