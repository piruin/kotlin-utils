import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt

fun Drawable.tint(@ColorInt color: Int, mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN) {
  mutate().setColorFilter(color, mode)
}
