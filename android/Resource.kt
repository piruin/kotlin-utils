import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.view.View

@ColorInt
fun Context.color(@ColorRes colorRes: Int) = ResourcesCompat.getColor(resources, colorRes, theme)

@ColorInt
fun Fragment.color(@ColorRes colorRes: Int) = context!!.color(colorRes)

@ColorInt
fun View.color(@ColorRes colorRes: Int) = context.color(colorRes)

fun Context.drawable(@DrawableRes drawableRes: Int) = ResourcesCompat.getDrawable(resources, drawableRes, theme)
fun Fragment.drawable(@DrawableRes drawableRes: Int) = context!!.drawable(drawableRes)
fun View.drawable(@DrawableRes drawableRes: Int) = context.drawable(drawableRes)
