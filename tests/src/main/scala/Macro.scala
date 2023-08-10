package example

import scala.quoted.*

private def idMacroImpl[A: Type](using ctx: Quotes): Expr[A => A] = '{ (a: A) => a }

inline def idMacro[A]: A => A = ${ idMacroImpl[A] }
