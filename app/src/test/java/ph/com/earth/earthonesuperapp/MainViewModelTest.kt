package ph.com.earth.earthonesuperapp

import app.cash.turbine.test
import arrow.core.some
import io.mockk.called
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Rule
import org.junit.Test
import ph.com.earth.data.user.UserRepository
import ph.com.earth.data.user.model.InAppUpdateResult

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val userRepository: UserRepository = mockk(relaxed = true)

    @Test
    fun `test MainUiState with default value of isLoading = true`() = runTest {
        //Arrange
        val userLoggedInFlow = MutableStateFlow(true)
        coEvery { userRepository.isUserLoggedIn } returns userLoggedInFlow

        //Action
        val underTest = MainViewModel(userRepository)
        runCurrent()

        //Assert
        underTest.uiState.test {
            val expectedValue = MainUiState(isLoading = false, startDestination = "home")
            val item = awaitItem()
            assertEquals(expectedValue, item)
        }
    }

    @Test
    fun `test MainUiState with default value of isLoading = false `() = runTest {
        //Arrange
        val userLoggedInFlow = MutableStateFlow(false)
        coEvery { userRepository.isUserLoggedIn } returns userLoggedInFlow

        //Action
        val underTest = MainViewModel(userRepository)
        runCurrent()

        //Assert
        underTest.uiState.test {
            val expectedValue = MainUiState(isLoading = false)
            assertEquals(expectedValue, awaitItem())
        }
    }

    @Test
    fun `test login`() = runTest {
        //Arrange
        val userLoggedInFlow = MutableStateFlow(true)
        coEvery { userRepository.isUserLoggedIn } returns userLoggedInFlow
        coEvery { userRepository.cacheUserLoggedInStatus(isLogin = true) } returns Unit

        //Action
        val underTest = MainViewModel(userRepository)
        underTest.login()
        runCurrent()

        //Assert
        underTest.uiState.test {
            assertEquals(
                MainUiState(isLoading = false, startDestination = "home"),
                awaitItem()
            )
        }
    }

    @Test
    fun `test MainUiState on token request`() = runTest {
        //Arrange
        val userLoggedInFlow = MutableStateFlow(true)
        every { userRepository.isUserLoggedIn } returns userLoggedInFlow
        coEvery { userRepository.checkInAppUpdate() } returns InAppUpdateResult.NoUpdate.some()
        val underTest = MainViewModel(userRepository)
        advanceUntilIdle()

        //Action
        launch {
            underTest.checkInAppUpdate()
        }

        //Assert
        underTest.inAppUpdateStatus.test {
            assertEquals(InAppUpdateResult.NoUpdate, awaitItem())
        }
    }
}