package ph.com.earth.data.cache.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.properties.ReadOnlyProperty

val DataStore<Preferences>.delegate get() = DatastoreDelegates(this)

class DatastoreDelegates(private val dataStore: DataStore<Preferences>) {

    companion object {
        val IS_USER_LOGIN_KEY = booleanPreferencesKey("isUserLogin")
        const val PREFERENCE_USER_SETTING = "userSettings"
    }

    fun boolean(): ReadOnlyProperty<Any, Flow<Boolean>> = ReadOnlyProperty { _, property ->
        dataStore.data.map {
            it[IS_USER_LOGIN_KEY] ?: false
        }
    }
}