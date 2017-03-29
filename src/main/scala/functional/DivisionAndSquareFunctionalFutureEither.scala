package motivationcompositionmonad
package functional


import Types.FutureEither
import cats.MonadError
import scala.concurrent.Future


trait DivisionAndSquareFunctionalFutureEither extends DivisionAndSquareFunctional[FutureEither] {
}
