package ph.com.earth.earthonesuperapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ph.com.earth.earthonesuperapp.ui.theme.EarthOneSuperAppTheme

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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = "Android", isTurboMode = true) {

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    name: String,
    isTurboMode: Boolean,
    onClick: () -> Unit = {},
) {
    val mesg = if (isTurboMode)
        "Super $name"
    else
        name
    Text(
        text = "Hello $mesg!",
        modifier = modifier.clickable {
            onClick()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EarthOneSuperAppTheme {
        Greeting(name = "Android", isTurboMode = false)
    }
}
