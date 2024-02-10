package ph.com.earth.data

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

val SharedPreferences.delegates get() = SharedPreferenceDelegates(this)

class SharedPreferenceDelegates(private val prefs: SharedPreferences) {
    fun boolean(default: Boolean = false, key: String? = null): ReadWriteProperty<Any, Boolean> =
        create(default = default, getter = prefs::getBoolean, setter = prefs.edit()::putBoolean)

    fun float(default: Float = 0.0f, key: String? = null): ReadWriteProperty<Any, Float> =
        create(default = default, getter = prefs::getFloat, setter = prefs.edit()::putFloat)

    fun long(default: Long = 0L, key: String? = null): ReadWriteProperty<Any, Long> =
        create(default = default, getter = prefs::getLong, setter = prefs.edit()::putLong)

    fun int(default: Int = 0, key: String? = null): ReadWriteProperty<Any, Int> =
        create(default = default, getter = prefs::getInt, setter = prefs.edit()::putInt)

    fun string(default: String = "", key: String? = null): ReadWriteProperty<Any, String> =
        create(
            default = default,
            getter = { k, d -> prefs.getString(k, d) as String },
            setter = prefs.edit()::putString
        )

    fun stringSet(
        default: Set<String> = emptySet(),
        key: String? = null,
    ): ReadWriteProperty<Any, Set<String>> =
        create(
            default = default,
            getter = { k, d -> prefs.getStringSet(k, d) as Set<String> },
            setter = prefs.edit()::putStringSet
        )


    private fun <T : Any> create(
        default: T,
        key: String? = null,
        getter: (key: String, default: T) -> T,
        setter: (key: String, value: T) -> SharedPreferences.Editor,
    ) = object : ReadWriteProperty<Any, T> {
        private fun key(property: KProperty<*>) = key ?: property.name

        override fun getValue(thisRef: Any, property: KProperty<*>): T =
            getter(key(property), default)


        override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
            setter(key(property), value).apply()
        }

    }
}

class UserRepository(preferences: SharedPreferences) {

    var turboMode: Boolean by preferences.delegates.boolean(true)
}