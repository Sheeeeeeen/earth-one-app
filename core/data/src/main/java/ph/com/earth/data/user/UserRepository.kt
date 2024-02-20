package ph.com.earth.data.user

import arrow.core.Option
import kotlinx.coroutines.flow.Flow
import ph.com.earth.data.user.model.InAppUpdateResult

interface UserRepository {

    val isUserLoggedIn: Flow<Boolean>
    suspend fun cacheUserLoggedInStatus(isLogin: Boolean)
    suspend fun checkInAppUpdate(): Option<InAppUpdateResult>
}