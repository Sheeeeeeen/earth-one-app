package ph.com.earth.earthonesuperapp.fake

import arrow.core.Option
import kotlinx.coroutines.flow.Flow
import ph.com.earth.data.user.UserRepository
import ph.com.earth.data.user.model.InAppUpdateResult

class FakeUserRepository: UserRepository {
    override val isUserLoggedIn: Flow<Boolean>
        get() = TODO("Not yet implemented")

    override suspend fun cacheUserLoggedInStatus(isLogin: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun checkInAppUpdate(): Option<InAppUpdateResult> {
        TODO("Not yet implemented")
    }
}