
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.TransitionRes
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionSet
import android.view.View
import android.support.v4.util.Pair as AndroidSupportPair

fun Context.transition(@TransitionRes res: Int) = TransitionInflater.from(this).inflateTransition(res)
fun Fragment.transition(@TransitionRes res: Int) = context!!.transition(res)
fun View.transition(@TransitionRes res: Int) = context.transition(res)

fun Activity.sceneTransition(vararg sharedElements: Pair<View, String>): Bundle? {
    return if (Build.VERSION.SDK_INT < 21) null else
        ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                *sharedElements.map { it.toAndroidSupportPair() }.toTypedArray()
        ).toBundle()
}

private fun Pair<View, String>.toAndroidSupportPair() = AndroidSupportPair(first, second)

var Fragment.allowTransitionOverlap: Boolean
    set(value) {
        allowEnterTransitionOverlap = value
        allowReturnTransitionOverlap = value
    }
    get() = throw IllegalAccessError()

@TargetApi(21)
fun Move(context: Context) = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

fun transitionSetOf(vararg transitions: Transition): TransitionSet {
    return TransitionSet().apply {
        transitions.forEach { this.addTransition(it) }
    }
}
