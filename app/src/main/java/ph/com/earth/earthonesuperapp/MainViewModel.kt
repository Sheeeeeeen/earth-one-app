package ph.com.earth.earthonesuperapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ph.com.earth.data.UserRepository

class MainViewModel constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<Boolean> = MutableStateFlow(userRepository.turboMode)
    val uiState = _uiState.asStateFlow()

    fun changeTurboMode(mode: Boolean) {
        userRepository.turboMode = mode
        _uiState.update { userRepository.turboMode }
    }
}