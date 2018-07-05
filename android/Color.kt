import android.content.Context
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.view.View

fun Int.toHue(): Float = toHSV()[0]

fun Int.toHSV(): FloatArray {
  val hsv = FloatArray(3)
  Color.colorToHSV(this, hsv)
  return hsv
}

@ColorInt fun Context.color(@ColorRes colorRes: Int) = ResourcesCompat.getColor(resources, colorRes, theme)
@ColorInt fun Fragment.color(@ColorRes colorRes: Int) = context!!.color(colorRes)
@ColorInt fun View.color(@ColorRes colorRes: Int) = context.color(colorRes)
