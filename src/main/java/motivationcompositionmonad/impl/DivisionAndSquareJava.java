package motivationcompositionmonad.impl;

import motivationcompositionmonad.functional.DivisionAndSquareFunctionalFutureEither;
import motivationcompositionmonad.functional.MonadErrorImpl;
import scala.concurrent.*;
import scala.util.*;
import cats.MonadError;
import scala.concurrent.Future;


public class DivisionAndSquareJava {
  
    public Integer division( int divident, int divisor )  {
      
      if ( divisor == 0 ) {
        
        throw new IllegalArgumentException( "Error divisor equals 0" );
      } 
      
      return divident / divisor;
      
    }
    
    public Double square( int value  ) {
      
      if( value < 0){
        
        throw new IllegalArgumentException( "Error value minus 0" );
            
      }else{
      
        return Math.sqrt(value);
      
      }
      
    }
  

    public Double divisionAndSquare( int divident, int divisor) {
      
      int resDivision =  division( divident, divisor);
      
      Double resSquare = square( resDivision );
      
      return resSquare;
      
    }  
}
