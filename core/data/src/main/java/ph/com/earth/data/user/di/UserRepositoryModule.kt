package ph.com.earth.data.user.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ph.com.earth.data.user.DefaultUserRepository
import ph.com.earth.data.user.UserRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindUserRepository(defaultUserRepository: DefaultUserRepository): UserRepository
}