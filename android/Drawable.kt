
import android.content.Context
import android.content.res.Resources.Theme
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import android.view.View

fun Drawable.tint(@ColorInt color: Int, mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN): Drawable {
  return apply { mutate().setColorFilter(color, mode) }
}

fun Drawable.toBitmap(): Bitmap {
  if (this is BitmapDrawable && bitmap != null) {
    return bitmap
  }

  val bitmap: Bitmap = if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
    Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
  } else {
    Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
  }

  val canvas = Canvas(bitmap)
  setBounds(0, 0, canvas.width, canvas.height)
  draw(canvas)
  return bitmap
}

fun Context.drawable(@DrawableRes drawableId: Int, theme: Theme? = null): Drawable {
  return if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
    resources.getDrawable(drawableId, theme)
  } else {
    @Suppress("DEPRECATION")
    resources.getDrawable(drawableId)
  }
}

fun Fragment.drawable(@DrawableRes drawableRes: Int, theme: Theme? = null) = context!!.drawable(drawableRes, theme)
fun View.drawable(@DrawableRes drawableRes: Int, theme: Theme? = null) = context.drawable(drawableRes, theme)
