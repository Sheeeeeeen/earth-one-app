package ph.com.earth.earthonesuperapp.fake

import kotlinx.coroutines.flow.Flow
import ph.com.earth.data.user.UserRepository

class FakeUserRepository: UserRepository {
    override val isUserLoggedIn: Flow<Boolean>
        get() = TODO("Not yet implemented")

    override suspend fun cacheUserIsLoggedIn(isLogin: Boolean) {
        TODO("Not yet implemented")
    }
}