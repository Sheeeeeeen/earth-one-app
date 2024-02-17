package ph.com.earth.user.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import ph.com.earth.user.login.LoginScreenRoute
import ph.com.earth.user.onboarding.OnboardingScreenRoute
import ph.com.earth.user.pin.EnterPinScreenRoute
import ph.com.earth.user.signup.SignupScreenRoute

const val loginNavigationRoute = "login-route"
const val onBoardingNavigationRoute = "on-boarding-route"
const val enterPinNavigationRoute = "enter-pin-route"
const val signupNavigationRoute = "signup-route"

fun NavGraphBuilder.userGraph(
    navigateToHome: () -> Unit = {},
    navigateToLogin: () -> Unit = {},
    navigateToEnterPin: () -> Unit = {},
    navigateToSignup: () -> Unit = {},
    nestedGraphs: NavGraphBuilder.() -> Unit = {},
) {
    composable(route = loginNavigationRoute) { LoginScreenRoute(navigateToEnterPin = navigateToEnterPin) }
    composable(route = onBoardingNavigationRoute) {
        OnboardingScreenRoute(
            navigateToLogin = navigateToLogin,
            navigateToSignup = navigateToSignup
        )
    }
    composable(route = enterPinNavigationRoute) { EnterPinScreenRoute(navigateToHome = navigateToHome) }
    composable(route = signupNavigationRoute) { SignupScreenRoute() }
    nestedGraphs()
}

fun NavController.navigateToLoginScreen(navOptions: NavOptions? = null) {
    this.navigate(route = loginNavigationRoute, navOptions = navOptions)
}

fun NavController.navigateToOnboardingScreen(navOptions: NavOptions? = null) {
    this.navigate(route = onBoardingNavigationRoute, navOptions = navOptions)
}

fun NavController.navigateToEnterPinScreen(navOptions: NavOptions? = null) {
    this.navigate(route = enterPinNavigationRoute, navOptions = navOptions)
}

fun NavController.navigateToSignupScreen(navOptions: NavOptions? = null) {
    this.navigate(route = signupNavigationRoute, navOptions = navOptions)
}