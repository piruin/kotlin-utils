import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

@Throws(IOException::class)
fun Context.assetAsString(filename: String): String {
    val reader = BufferedReader(InputStreamReader(getAssets().open(filename)))
    return reader.readText()
}