package ph.com.earth.user.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SignupScreenRoute() {
    SignupScreen()
}

@Composable
private fun SignupScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(text = "Signup")
    }
}

@Preview(showBackground = true)
@Composable
private fun SignupScreenPreview() {
    SignupScreen()
}