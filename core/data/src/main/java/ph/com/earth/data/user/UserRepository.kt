package ph.com.earth.data.user

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    val isUserLoggedIn: Flow<Boolean>
    suspend fun cacheUserLoggedInStatus(isLogin: Boolean)
}