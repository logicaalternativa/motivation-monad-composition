package motivationcompositionmonad

object DivisionAndSquareAsJava {
  
    def division( divident : Int, divisor : Int ) : Int = {
        
        divisor match {
        
          case 0 => throw new IllegalArgumentException( "Error divisor equals 0" )
          case value =>  divident / value  
          
        }
      
    }
    
    def square( value : Int ) : Double = {
      
      import scala.math.sqrt
      
      if( value < 0){
        
        throw new IllegalArgumentException( "Error value minus 0" )
            
      }else{
      
        sqrt(value)
      
      }
      
    }
  

    def divisionAndSquare( divident : Int, divisor : Int ) : Double = {
      
      val resDivision =  division( divident, divisor )
      
      val resSquare = square( resDivision )
      
      resSquare
      
    }
  
}
