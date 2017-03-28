package motivationcompositionmonad

import scala.util.{Try, Success, Failure}

object DivisionAndSquareTry {
  
    def division( divident : Int, divisor : Int ) : Try[Int] = {
        
        divisor match {
        
          case 0 => Failure( new IllegalArgumentException( "Error divisor equals 0" ) )
          case value => Success( divident / value)  
           
        }
        
      
    }
    
    def square( value : Int ) : Try[Double] = {
      
      import scala.math.sqrt
      //~ 
      //~ if( value < 0){
        //~ 
        //~ Option.empty
            //~ 
      //~ }else{
      //~ 
        //~ Option( sqrt(value) )
      //~ 
      //~ }
      
      if( value < 0){
      
        Failure ( new IllegalArgumentException( "Error value minus 0" ) ) 
        
      }else{
      
         Success(sqrt(value)) 
        
      }
      
       
    }
  

    def divisionAndSquare( divident : Int, divisor : Int ) : Try[Double] = {


       for {
       
          resDivision <- division(divident,divisor)  
                  
          resSquare <- square(resDivision)            
       
       } yield resSquare
                 
    }
  
}