package ph.com.earth.earthonesuperapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ph.com.earth.data.user.UserRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    fun login() {
        viewModelScope.launch {
            userRepository.cacheUserLoggedInStatus(isLogin = true)
        }
    }

    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            userRepository.isUserLoggedIn.collect { status ->
                val currentDestination = if (status) "home" else null
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        startDestination = currentDestination
                    )
                }
            }
        }
    }
}

data class MainUiState(val isLoading: Boolean = true, val startDestination: String? = null)