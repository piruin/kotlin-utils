import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.support.v4.util.Pair as AndroidSupportPair

fun Activity?.isActive() = this != null && !this.isFinishing() && !this.isDestroyed()

fun Activity.sceneTransition(vararg sharedElements: Pair<View, String>): Bundle? {
    return if (Build.VERSION.SDK_INT < 21) null else
        ActivityOptionsCompat.makeSceneTransitionAnimation(this, *sharedElements.map { it.toAndroidSupportPair() }.toTypedArray()).toBundle()
}

private fun Pair<View, String>.toAndroidSupportPair() = AndroidSupportPair(first, second)
