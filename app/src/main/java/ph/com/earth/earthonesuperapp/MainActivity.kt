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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ph.com.earth.data.UserRepository
import ph.com.earth.earthonesuperapp.ui.theme.EarthOneSuperAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels(factoryProducer = {
        val prefs = MySharedPrefsManager.create(this)
        val userRepo = UserRepository(prefs)
        MainViewModelModelFactory(
            userRepository = userRepo
        )
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val uiState = viewModel.uiState.collectAsState()

            EarthOneSuperAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = "Android", isTurboMode = uiState.value) {
                        viewModel.changeTurboMode(uiState.value.not())
                    }
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    inner class MainViewModelModelFactory(val userRepository: UserRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(userRepository = userRepository) as T
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    name: String,
    isTurboMode: Boolean = false,
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
        Greeting(name = "Android")
    }
}
