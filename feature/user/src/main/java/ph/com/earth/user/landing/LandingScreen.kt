package ph.com.earth.user.landing

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ph.com.earth.designsystem.ui.theme.AppPreview
import ph.com.earth.designsystem.util.autoScroll
import ph.com.earth.user.R

@Composable
fun LandingScreenRoute(navigateToLogin: () -> Unit, navigateToSignup: () -> Unit) {
    LandingScreen(navigateToLogin = navigateToLogin, navigateToSignup = navigateToSignup)
}

@Composable
internal fun LandingScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit = {},
    navigateToSignup: () -> Unit = {},
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        BackgroundCarousel()
        Column(modifier = modifier.wrapContentHeight().fillMaxWidth().padding(24.dp)) {
            Icon(
                painter = painterResource(R.drawable.ic_globe_one_logo),
                contentDescription = "new-globe-one-icon",
                tint = Color.Unspecified,
            )
            Spacer(Modifier.height(16.dp).fillMaxWidth())
            Text(
                text = "WELCOME TO GLOBEONE",
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                letterSpacing = 2.sp,
                color = MaterialTheme.colorScheme.background
            )
            Spacer(Modifier.height(4.dp).fillMaxWidth())
            Text(
                text = "Your digital life essentials right at your fingertips",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.background
            )
            Spacer(Modifier.height(8.dp).fillMaxWidth())
            Text(
                text = "Join our community now!",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
            )
            Spacer(Modifier.height(32.dp).fillMaxWidth())
            CreateAnAccountButton(
                modifier = Modifier.fillMaxWidth(),
                onCreateAnAccount = navigateToSignup
            )
            Spacer(Modifier.height(8.dp).fillMaxWidth())
            LoginButton(modifier = Modifier.fillMaxWidth(), onLogin = navigateToLogin)
        }
    }
}

@Composable
private fun LoginButton(modifier: Modifier = Modifier, onLogin: () -> Unit) {
    TextButton(
        modifier = modifier.fillMaxWidth().height(50.dp),
        onClick = onLogin,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
        ),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.background)
    ) {
        Text("Log in")
    }
}

@Composable
private fun CreateAnAccountButton(modifier: Modifier = Modifier, onCreateAnAccount: () -> Unit) {
    TextButton(
        modifier = modifier.fillMaxWidth().height(50.dp),
        onClick = onCreateAnAccount,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        )
    ) {
        Text(text = "Create an account")
    }
}

@Composable
private fun BackgroundCarousel(
    itemsCount: Int = Int.MAX_VALUE,
    listState: LazyListState = rememberLazyListState(),
) {
    LaunchedEffect(Unit) {
        while (true) {
            listState.autoScroll()
        }
    }
    LazyRow(
        modifier = Modifier.fillMaxSize().background(color = Color.Transparent.copy(alpha = 0.2f)),
        state = listState,
        userScrollEnabled = false
    ) {
        items(itemsCount) {
            Image(
                modifier = Modifier.fillMaxHeight().wrapContentWidth(),
                painter = painterResource(R.drawable.new_login_background),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
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