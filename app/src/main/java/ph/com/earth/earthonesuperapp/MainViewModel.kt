package ph.com.earth.earthonesuperapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ph.com.earth.data.UserRepository

class MainViewModel constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            userRepository.isUserLoggedIn.collect { loginStatus ->
                _uiState.update { loginStatus }
            }
        }
    }

    fun changeTurboMode(mode: Boolean) {
        viewModelScope.launch {
            userRepository.cacheUserIsLoggedIn(isLogin = mode)
        }
    }
}