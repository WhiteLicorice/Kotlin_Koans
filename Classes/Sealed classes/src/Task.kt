fun eval(expr: Expr): Int {
    return when (expr) {
        is Num -> return expr.value
        is Sum -> eval(expr.right) + eval(expr.left)
    }
}

sealed interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
