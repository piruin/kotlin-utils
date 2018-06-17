import android.app.Activity

fun Activity?.isActive() = this != null && !this.isFinishing() && !this.isDestroyed()
