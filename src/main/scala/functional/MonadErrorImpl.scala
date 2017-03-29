package motivationcompositionmonad
package functional


import Types.FutureEither
import cats.MonadError
import scala.concurrent.Future

  
object MonadErrorImpl {
  
  implicit val EFutureEither : MonadError[FutureEither, Throwable] = new  MonadError[FutureEither, Throwable] {
    
    import scala.concurrent.ExecutionContext.Implicits.global
  
    // Members declared in cats.Applicative
    def pure[A](x: A): FutureEither[A] = Future( Right( x ) )
    
    // Members declared in cats.ApplicativeError
    def handleErrorWith[A](fa: FutureEither[A])(f: Throwable => FutureEither[A]): FutureEither[A] = {
      
      for {
        
        res <- fa
        
        resError <- res match{
          
            case Right(value) => pure( value )
            case Left (error) => f( error ) 
            
          } 
        
        
      } yield resError
      
      
      }
    
    def raiseError[A](e: Throwable): FutureEither[A] = Future( Left( e ) )
    
    // Members declared in cats.FlatMap
    def flatMap[A, B](fa: FutureEither[A])(f: A => FutureEither[B]): FutureEither[B] = {
      
      
      for {
        
        resF : Either[Throwable,A] <- fa
        
        res <- resF match {
                  case Right( value ) => f( value )            
                  case Left ( error ) => raiseError( error )  
                }
        
      } yield res
      
    }
    
    def tailRecM[A, B](a: A)(f: A => FutureEither[Either[A,B]]): FutureEither[B] = {
      
        for {
          
          res :Either[Throwable, Either[A,B]]  <- f( a )
          
          resF : Either[Throwable, B] <-   res match {
                                              case Left( error ) => raiseError( error )
                                              case Right( value: Either[A,B] ) => 
                                                value match {
                                                    case Right( b ) => pure( b )
                                                    case Left( a ) =>  tailRecM( a )( f )                         
                                                }
                                            }
          
          
        } yield resF
      
      
    }
    
    
    
  }


}
