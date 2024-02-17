package ph.com.earth.earthonesuperapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ph.com.earth.earthonesuperapp.navigation.EarthOneNavHost
import ph.com.earth.user.navigation.loginNavigationRoute

@Composable
fun EarthOneApp(
    mainUiState: MainUiState,
    navController: NavHostController = rememberNavController(),
) {
    EarthOneNavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = mainUiState.startDestination ?: loginNavigationRoute
    )
}