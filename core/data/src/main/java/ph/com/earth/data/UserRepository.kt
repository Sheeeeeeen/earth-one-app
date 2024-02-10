package ph.com.earth.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import ph.com.earth.data.cache.datastore.DatastoreDelegates.Companion.IS_USER_LOGIN_KEY
import ph.com.earth.data.cache.datastore.delegate
import javax.inject.Inject

class UserRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {

    val isUserLoggedIn: Flow<Boolean> by dataStore.delegate.boolean()
    suspend fun cacheUserIsLoggedIn(isLogin: Boolean) {
        dataStore.edit { pref ->
            pref[IS_USER_LOGIN_KEY] = isLogin
        }
    }
}