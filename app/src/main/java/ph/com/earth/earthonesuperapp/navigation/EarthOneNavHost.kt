package ph.com.earth.earthonesuperapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ph.com.earth.user.navigation.navigateToEnterPinScreen
import ph.com.earth.user.navigation.navigateToLoginScreen
import ph.com.earth.user.navigation.navigateToSignupScreen
import ph.com.earth.user.navigation.onBoardingNavigationRoute
import ph.com.earth.user.navigation.userGraph

@Composable
fun EarthOneNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String? = null,
) {
    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination ?: onBoardingNavigationRoute,
    ) {
        userGraph(
            navigateToHome = { navController.navigate("home") },
            navigateToLogin = { navController.navigateToLoginScreen() },
            navigateToSignup = { navController.navigateToSignupScreen() },
            navigateToEnterPin = { navController.navigateToEnterPinScreen() }
        )
        composable(route = "home") {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = "home")
            }
        }
    }
}