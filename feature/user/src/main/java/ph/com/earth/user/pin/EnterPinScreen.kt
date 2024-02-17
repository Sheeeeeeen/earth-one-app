package ph.com.earth.user.pin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EnterPinScreenRoute(navigateToHome: () -> Unit) {
    EnterPinScreen(navigateToHome = navigateToHome)
}

@Composable
fun EnterPinScreen(modifier: Modifier = Modifier, navigateToHome: () -> Unit = {}) {
    Box(modifier = modifier.fillMaxSize()) {
        OutlinedButton(
            modifier = Modifier.fillMaxWidth().align(alignment = Alignment.Center),
            onClick = navigateToHome
        ) {
            Text("Enter Pin")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EnterPinScreenPreview() {
    EnterPinScreen()
}