import android.content.Context
import android.support.design.widget.TextInputLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText

fun <T : View> T.onClick(listener: (T) -> Unit) = setOnClickListener { listener(this) }

fun <T : View> T.onLongClick(listener: (T) -> Boolean) = setOnLongClickListener { listener(this) }

fun View.requestScroll(focus: Boolean = true) {
    if (focus) requestFocus()
    parent.requestChildFocus(this, this)
}

fun View.disable() {
    isEnabled = false
}

fun View.enable() {
    isEnabled = true
}

val EditText.isError
    get() = this.textInputLayout?.error?.isNotBlank() == true || error.isNotBlank()

val View.textInputLayout: TextInputLayout?
    get() {
        if (this.parent == null) return null
        return when {
            this.parent is TextInputLayout -> this.parent as TextInputLayout
            this.parent is View -> (this.parent as View).textInputLayout
            else -> null
        }
    }

fun View.gone() = updateVisibility(View.GONE)

fun View.invisible() = updateVisibility(View.INVISIBLE)

fun View.visible() = updateVisibility(View.VISIBLE)

private fun View.updateVisibility(visibility: Int) {
    when {
        this.textInputLayout != null -> this.textInputLayout!!.visibility = visibility
        else -> this.visibility = visibility
    }
}

val View.layoutInflater: LayoutInflater
    get() = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
