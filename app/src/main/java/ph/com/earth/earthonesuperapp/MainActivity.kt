package ph.com.earth.earthonesuperapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ph.com.earth.designsystem.ui.theme.EarthOneSuperAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()

        lifecycleScope.launch {
            viewModel.uiState.collect {
                splashScreen.setKeepOnScreenCondition { it.isLoading }
            }
        }

        setContent {
            EarthOneSuperAppTheme {
                val uiState by viewModel.uiState.collectAsState()
                EarthOneApp(mainUiState = uiState)
            }
        }
    }
}
