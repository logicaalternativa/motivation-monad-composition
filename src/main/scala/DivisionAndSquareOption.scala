package motivationcompositionmonad

object DivisionAndSquareOption extends DivisionAndSquare[Option] {
  
    def division( divident : Int, divisor : Int ) : Option[Int] = {
        
        divisor match {
        
          case 0 => Option.empty
          case value => Option( divident / value)  
          
        }
      
    }
    
    def squareR( value : Int ) : Option[Double] = {
      
      import scala.math.sqrt
      
      if( value < 0){
        
        Option.empty
            
      }else{
      
        Option( sqrt(value) )
      
      }
      
    }
  

    override def divisionAndSquareR( divident : Int, divisor : Int ) : Option[Double] = {

       for {
       
          resDivision <- division(divident,divisor)  
                  
          resSquare <- squareR(resDivision)            
       
       } yield resSquare
                 
    }
  
}
