package ph.com.earth.user.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph.com.earth.designsystem.ui.theme.AppPreview

@Composable
fun LoginScreenRoute(navigateToEnterPin: () -> Unit) {
    LoginScreen(navigateToEnterPin = navigateToEnterPin)
}

@Composable
private
fun LoginScreen(modifier: Modifier = Modifier, navigateToEnterPin: () -> Unit = {}) {
    Box(modifier = modifier.fillMaxSize()) {
        Button(
            modifier = Modifier.fillMaxWidth().align(alignment = Alignment.Center),
            onClick = navigateToEnterPin
        ) {
            Text("Login")
        }
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
private fun LoginScreenPreview() {
    AppPreview {
        LoginScreen()
    }
}