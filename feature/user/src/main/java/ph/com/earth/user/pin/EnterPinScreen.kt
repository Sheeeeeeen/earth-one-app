package ph.com.earth.user.pin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EnterPinScreenRoute() {
    EnterPinScreen()
}

@Composable
fun EnterPinScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(text = "Enter Pin")
    }
}

@Preview(showBackground = true)
@Composable
private fun EnterPinScreenPreview() {
    EnterPinScreen()
}