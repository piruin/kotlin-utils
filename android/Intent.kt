import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.app.Fragment

fun Context.deepLink(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    intent.`package` = this.packageName
    startActivity(intent)
}

fun Fragment.deepLink(url: String) = context!!.deepLink(url)
