package ph.com.earth.earthonesuperapp

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runCurrent
import org.junit.Rule
import org.junit.Test
import ph.com.earth.data.user.UserRepository

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val userRepository: UserRepository = mockk()

    private val mainViewModel: MainViewModel = MainViewModel(userRepository)

    @Test
    fun `test MainUiState with default value of isLoading = true `() = testCoroutineRule.runTest {

        val userLoggedInFlow = MutableStateFlow(true)

        coEvery { userRepository.isUserLoggedIn } returns userLoggedInFlow

        mainViewModel.observeUserLoggedInStatus()

        runCurrent()

        mainViewModel.uiState.test {
            val expectedValue = MainUiState(isLoading = true)
            assertEquals(expectedValue, awaitItem())
        }

        verify { userRepository.isUserLoggedIn }
    }

    @Test
    fun `test MainUiState with default value of isLoading = false `() = testCoroutineRule.runTest {
        val userLoggedInFlow = MutableStateFlow(false)

        coEvery { userRepository.isUserLoggedIn } returns userLoggedInFlow

        mainViewModel.observeUserLoggedInStatus()

        runCurrent()

        mainViewModel.uiState.test {
            val expectedValue = MainUiState(isLoading = false)
            assertEquals(expectedValue, awaitItem())
        }

        verify { userRepository.isUserLoggedIn }
    }
}