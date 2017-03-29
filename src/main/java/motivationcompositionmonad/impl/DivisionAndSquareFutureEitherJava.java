package motivationcompositionmonad.impl;

import motivationcompositionmonad.functional.DivisionAndSquareFunctionalFutureEither;
import motivationcompositionmonad.functional.MonadErrorImpl;
import scala.concurrent.*;
import scala.util.*;
import cats.MonadError;
import scala.concurrent.Future;


public class DivisionAndSquareFutureEitherJava implements DivisionAndSquareFunctionalFutureEither {
  
  public MonadError<Future,Throwable> E() {
    
      return MonadErrorImpl.EFutureEither();
  }
  
  
  private Integer _division( int divident, int divisor, int res ) {
  
    if ( res * Math.abs(divisor) >= Math.abs( divident ) ) {
      
        int resFinal = res;
      
        if ( divisor < 0  ) {
            
          resFinal = -1 * resFinal;
          
        }
        
        if ( divident < 0 ) {
         
          resFinal = -1 * resFinal;
          
        }
          
    
        return resFinal;
      
    } else {
        
        return _division( divident, divisor, res + 1 );
      
    }
    
  } 

  public Future<Either<Throwable,Integer>> division( int divident, int divisor ) {
    
      Either<Throwable,Integer> res =  ( divisor == 0 ) 
                                          ? new Left<>( new IllegalArgumentException( "Error divisor equals 0" ) )
                                            : new Right<>( _division( divident, divisor, 1 ) );
      
      return Future.successful( res );    
    
  } 
  
  public Future<Either<Throwable,Double>> square( int value ) {
    
    Either<Throwable,Double> res =  ( value < 0  )
                    ? new Left<>( new IllegalArgumentException( "Error value minus 0" ) )
                      : new Right( Math.pow( value, 0.5 ) );
    
    return Future.successful( res );
      
  }
  
}
