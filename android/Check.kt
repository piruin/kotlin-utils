import android.view.View

class ViewValidateDsl<T : View> {

    var condition: (T.() -> Boolean)? = null
    lateinit var message: String
    lateinit var validate: T.() -> Boolean

    fun on(condition: T.() -> Boolean) {
        this.condition = condition
    }

    fun that(validate: T.() -> Boolean) {
        this.validate = validate
    }
}

inline fun <T : View> T.check(block: ViewValidateDsl<T>.() -> Unit) {
    val dsl = ViewValidateDsl<T>().apply(block)
    error(null)
    if (dsl.condition == null || dsl.condition?.invoke(this) == true) {
        val valid = dsl.validate(this)
        if (!valid) {
            error(dsl.message)
            throw IllegalStateException(dsl.message)
        }
    }
}
