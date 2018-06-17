import android.app.Activity
import android.app.Fragment
import android.view.View

fun Context.require(value: Boolean, @StringRes resId: Int) = require(value) { getString(resId) }
fun Fragment.require(value: Boolean, @StringRes resId: Int) = activity.require(value, resId)
fun View.require(value: Boolean, @StringRes resId: Int) = context.require(value, resId)
