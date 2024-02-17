package ph.com.earth.earthonesuperapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun EarthOneNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "login",
) {
    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = "login") {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = "Login")
            }
        }
        composable(route = "home") {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = "home")
            }
        }
    }
}