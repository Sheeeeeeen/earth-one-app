package ph.com.earth.user.landing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph.com.earth.designsystem.ui.theme.AppPreview

@Composable
fun LandingScreenRoute(navigateToLogin: () -> Unit, navigateToSignup: () -> Unit) {
    LandingScreen(navigateToLogin = navigateToLogin, navigateToSignup = navigateToSignup)
}

@Composable
private fun LandingScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit = {},
    navigateToSignup: () -> Unit = {},
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Landing",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.fillMaxSize().weight(1f))
        Button(modifier = Modifier.fillMaxWidth(), onClick = navigateToLogin) {
            Text("Log in")
        }
        Button(modifier = Modifier.fillMaxWidth(), onClick = navigateToSignup) {
            Text("Create an account")
        }
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
private fun LandingScreenPreview() {
    AppPreview {
        LandingScreen()
    }
}