import android.graphics.Color

fun Int.toHue(): Float = toHSV()[0]

fun Int.toHSV(): FloatArray {
  val hsv = FloatArray(3)
  Color.colorToHSV(this, hsv)
  return hsv
}
