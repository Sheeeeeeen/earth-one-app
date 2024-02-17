package ph.com.earth.earthonesuperapp

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
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
}