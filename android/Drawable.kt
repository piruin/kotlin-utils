/**
 * MIT License
 *
 * Copyright (c) 2018 Piruin Panichphol
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
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


fun Context.drawable(@DrawableRes drawableRes: Int) = ResourcesCompat.getDrawable(resources, drawableRes, theme)
fun Fragment.drawable(@DrawableRes drawableRes: Int) = context!!.drawable(drawableRes)
fun View.drawable(@DrawableRes drawableRes: Int) = context.drawable(drawableRes)
