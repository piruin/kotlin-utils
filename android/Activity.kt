import android.app.Activity

fun Activity?.isActive() = this != null && !this.isFinishing() && !this.isDestroyed()

fun Activity.sceneTransition(pair: Pair<View, String>): Bundle? {
    return if (Build.VERSION.SDK_INT < 21) null else
        ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair.first, pair.second).toBundle()
}
