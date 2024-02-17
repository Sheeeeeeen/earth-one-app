package ph.com.earth.data.user

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import ph.com.earth.data.cache.datastore.DatastoreDelegates.Companion.IS_USER_LOGIN_KEY
import ph.com.earth.data.cache.datastore.delegate
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(private val dataStore: DataStore<Preferences>) :
    UserRepository {

    override val isUserLoggedIn: Flow<Boolean> by dataStore.delegate.boolean(key = IS_USER_LOGIN_KEY)

    override suspend fun cacheUserLoggedInStatus(isLogin: Boolean) {
        dataStore.edit { pref -> pref[IS_USER_LOGIN_KEY] = isLogin }
    }
}