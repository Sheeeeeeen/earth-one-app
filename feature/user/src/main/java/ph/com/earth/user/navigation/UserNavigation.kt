package ph.com.earth.user.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ph.com.earth.user.login.LoginScreenRoute
import ph.com.earth.user.onboarding.OnboardingScreenRoute
import ph.com.earth.user.pin.EnterPinScreenRoute
import ph.com.earth.user.signup.SignupScreenRoute

const val loginNavigationRoute = "login-route"
const val onBoardingNavigationRoute = "on-boarding-route"
const val enterPinNavigationRoute = "enter-pin-route"
const val signupNavigationRoute = "signup-route"

fun NavGraphBuilder.userGraph(nestedGraphs: NavGraphBuilder.() -> Unit = {}) {
    composable(route = loginNavigationRoute) { LoginScreenRoute() }
    composable(route = onBoardingNavigationRoute) { OnboardingScreenRoute() }
    composable(route = enterPinNavigationRoute) { EnterPinScreenRoute() }
    composable(route = signupNavigationRoute) { SignupScreenRoute() }
    nestedGraphs()
}