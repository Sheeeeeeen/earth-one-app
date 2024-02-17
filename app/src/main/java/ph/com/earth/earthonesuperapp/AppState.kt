package ph.com.earth.earthonesuperapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberAppState(
    mainUiState: MainUiState,
    navController: NavHostController = rememberNavController(),
): AppState {
    return remember(navController, mainUiState) {
        AppState(mainUiState = mainUiState, navController = navController)
    }
}

@Stable
class AppState(
    val mainUiState: MainUiState,
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val startDestination = mainUiState.startDestination

}