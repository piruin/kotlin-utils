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
