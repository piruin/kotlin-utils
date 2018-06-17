import android.animation.ObjectAnimator
import android.view.View

//Translation X or Y by value in pixel
fun View.animTranslationX(value: Float) = ObjectAnimator.ofFloat(this, View.TRANSLATION_X, value)!!
fun View.animTranslationX(value: Int) = this.animTranslationX(value.toFloat())
fun View.animTranslationY(value: Float) = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, value)!!
fun View.animTranslationY(value: Int) = this.animTranslationY(value.toFloat())

fun View.animAlpha(value: Float) = ObjectAnimator.ofFloat(this, View.ALPHA, value)!!
