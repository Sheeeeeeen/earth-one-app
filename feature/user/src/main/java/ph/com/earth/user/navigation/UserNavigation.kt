package ph.com.earth.user.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ph.com.earth.user.login.LoginScreenRoute

const val loginNavigationRoute = "login-route"

fun NavGraphBuilder.userGraph(
    navToDashboard: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit = {},
) {
    composable(route = loginNavigationRoute) {
        LoginScreenRoute()
    }
}