package ph.com.earth.designsystem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph.com.earth.designsystem.ui.theme.EarthOneSuperAppTheme

@Composable
fun SampleScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Sample")
    }
}

@Preview(showBackground = true, showSystemUi = true, apiLevel = 33)
@Composable
fun SampleScreenPreview() {
    EarthOneSuperAppTheme {
        SampleScreen()
    }
}