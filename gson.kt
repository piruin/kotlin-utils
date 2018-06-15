import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

fun Any.toJson(gson: Gson = defaultGson)
        = gson.toJson(this)

inline fun <reified T> String.parseTo(gson: Gson = defaultGson): T
        = gson.fromJson(this, object : TypeToken<T>() {}.type)

inline fun <reified T> GsonBuilder.adapterFor(adapter: Any): GsonBuilder {
    return registerTypeAdapter(object : TypeToken<T>() {}.type, adapter)
}

//Build your application gson as you want
val defaultGson = GsonBuilder().create()
