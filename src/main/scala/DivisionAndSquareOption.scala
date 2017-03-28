package motivationcompositionmonad

object DivisionAndSquareOption {
  
    def division( divident : Int, divisor : Int ) : Option[Int] = {
        
        divisor match {
        
          case 0 => Option.empty
          case value => Option( divident / value)  
          
        }
      
    }
    
    def square( value : Int ) : Option[Double] = {
      
      import scala.math.sqrt
      
      if( value < 0){
        
        Option.empty
            
      }else{
      
        Option( sqrt(value) )
      
      }
      
    }
  

    def divisionAndSquare( divident : Int, divisor : Int ) : Option[Double] = {


       for {
       
          resDivision <- division(divident,divisor)  
                  
          resSquare <- square(resDivision)            
       
       } yield resSquare
                 
    }
  
}
