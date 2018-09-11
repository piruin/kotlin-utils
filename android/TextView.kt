@file:Suppress("DEPRECATION")

import android.graphics.drawable.Drawable
import android.widget.TextView

fun TextView.getDouble(default: Double? = null): Double? {
  val text = text.toString()
  if (text.isBlank()) return default
  return text.toDouble()
}

fun View.error(message: String?) {
    if (textInputLayout != null)
        textInputLayout?.error = message
    else if (this is TextView)
        error = message
}

@Deprecated("Consider replace with drawableStart to better support right-to-left Layout", ReplaceWith("drawableStart"), DeprecationLevel.WARNING)
var TextView.drawableLeft: Drawable?
  get() = compoundDrawables[0]
  set(drawable) = setCompoundDrawablesWithIntrinsicBounds(drawable, drawableTop, drawableRight, drawableBottom)

var TextView.drawableStart: Drawable?
  get() = compoundDrawablesRelative[0]
  set(drawable) = setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawableTop, drawableEnd, drawableBottom)

var TextView.drawableTop: Drawable?
  get() = compoundDrawablesRelative[1]
  set(drawable) = setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart, drawable, drawableEnd, drawableBottom)

@Deprecated("Consider replace with drawableEnd to better support right-to-left Layout", ReplaceWith("drawableEnd"), DeprecationLevel.WARNING)
var TextView.drawableRight: Drawable?
  get() = compoundDrawables[2]
  set(drawable) = setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawable, drawableBottom)

var TextView.drawableEnd: Drawable?
  get() = compoundDrawablesRelative[2]
  set(drawable) = setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart, drawableTop, drawable, drawableBottom)

var TextView.drawableBottom: Drawable?
  get() = compoundDrawablesRelative[3]
  set(drawable) = setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart, drawableTop, drawableEnd, drawable)
