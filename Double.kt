import java.text.NumberFormat
import kotlin.math.pow

fun Double.format(): String = NumberFormat.getInstance().format(this)

infix fun Double.and(second: Double) = Pair(this, second)

infix fun Double.between(values: Pair<Double, Double>) = values.first <= this && this <= values.second

fun Double.toRadians() = Math.toRadians(this)

val Double.fractional
    get() = this - this.toInt()

val Double.wholeNum
    get() = (this - this.fractional).toInt()

fun Double.round(digitLength: Int): Double {
    val pow = 10.0.pow(digitLength)
    return Math.round(this * pow) / pow
}
