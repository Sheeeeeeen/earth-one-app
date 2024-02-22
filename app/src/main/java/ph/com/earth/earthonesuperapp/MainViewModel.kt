package ph.com.earth.earthonesuperapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ph.com.earth.data.user.UserRepository
import ph.com.earth.data.user.model.InAppUpdateResult
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    private val _inAppUpdateStatus: MutableSharedFlow<InAppUpdateResult> = MutableSharedFlow()
    val inAppUpdateStatus = _inAppUpdateStatus.asSharedFlow()

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

    suspend fun checkInAppUpdate(){
        userRepository.checkInAppUpdate().onSome {
            _inAppUpdateStatus.emit(it)
        }
    }

    fun login() {
        viewModelScope.launch { userRepository.cacheUserLoggedInStatus(isLogin = true) }
    }
}

data class MainUiState(val isLoading: Boolean = true, val startDestination: String? = null)