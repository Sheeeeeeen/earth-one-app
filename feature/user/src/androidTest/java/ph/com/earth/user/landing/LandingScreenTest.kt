package ph.com.earth.user.landing

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LandingScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup(){
        composeTestRule.setContent {
            LandingScreen()
        }
    }
    @Test
    fun landing_screen_default_state() {
        composeTestRule.landingRobot {
            it.checkScreenContent()
        }
    }
}