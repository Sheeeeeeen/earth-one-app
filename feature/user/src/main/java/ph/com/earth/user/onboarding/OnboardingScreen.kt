package ph.com.earth.user.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingScreenRoute(navigateToLogin: () -> Unit, navigateToSignup: () -> Unit) {
    OnboardingScreen(navigateToLogin = navigateToLogin, navigateToSignup = navigateToSignup)
}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit = {},
    navigateToSignup: () -> Unit = {},
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Onboarding",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.fillMaxSize().weight(1f))
        Button(modifier = Modifier.fillMaxWidth(), onClick = navigateToLogin) {
            Text("Login")
        }
        Button(modifier = Modifier.fillMaxWidth(), onClick = navigateToSignup) {
            Text("Signup")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen()
}