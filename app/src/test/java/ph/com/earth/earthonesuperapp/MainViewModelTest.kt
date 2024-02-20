package ph.com.earth.earthonesuperapp

import arrow.core.Either
import arrow.core.Option
import arrow.core.some
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import ph.com.earth.data.user.UserRepository
import ph.com.earth.data.user.model.InAppUpdateResult

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val testCoroutineDispatcher: TestDispatcher = UnconfinedTestDispatcher()

    private val userRepository: UserRepository = mockk()

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test MainUiState with default value of isLoading = true`() = runTest {
        //Arrange
        val userLoggedInFlow = MutableStateFlow(true)
        coEvery { userRepository.isUserLoggedIn } returns userLoggedInFlow

        //Action
        mainViewModel = MainViewModel(userRepository)
        runCurrent()

        //Assert
        val expectedValue = MainUiState(isLoading = false, startDestination = "home")
        assertEquals(expectedValue, mainViewModel.uiState.value)
        verify { userRepository.isUserLoggedIn }
    }

    @Test
    fun `test MainUiState with default value of isLoading = false `() = runTest {
        //Arrange
        val userLoggedInFlow = MutableStateFlow(false)
        coEvery { userRepository.isUserLoggedIn } returns userLoggedInFlow

        //Action
        mainViewModel = MainViewModel(userRepository)
        runCurrent()

        //Assert
        val expectedValue = MainUiState(isLoading = false)
        assertEquals(expectedValue, mainViewModel.uiState.value)
        verify { userRepository.isUserLoggedIn }
    }

    @Test
    fun `test login`() = runTest {
        //Arrange
        val userLoggedInFlow = MutableStateFlow(true)
        coEvery { userRepository.isUserLoggedIn } returns userLoggedInFlow
        coEvery { userRepository.cacheUserLoggedInStatus(isLogin = true) } returns Unit

        //Action
        mainViewModel = MainViewModel(userRepository)
        mainViewModel.login()
        runCurrent()

        //Assert
        assertEquals(
            MainUiState(isLoading = false, startDestination = "home"),
            mainViewModel.uiState.value
        )
        verify { userRepository.isUserLoggedIn }
        coVerify { userRepository.cacheUserLoggedInStatus(isLogin = true) }
    }

    @Test
    fun `test MainUiState on token request`() = runTest {
        //Arrange
        coEvery { userRepository.checkInAppUpdate() } returns InAppUpdateResult.NoUpdate.some()
        //Action

        mainViewModel = MainViewModel(userRepository)
        runCurrent()

        //Assert
        assertEquals(
            InAppUpdateResult.NoUpdate,
            mainViewModel.inAppUpdateStatus.first()
        )
        coVerify { userRepository.checkInAppUpdate() }
    }

}