package ph.com.earth.user.landing

import androidx.compose.ui.test.junit4.ComposeTestRule
import ph.com.earth.user.BaseRobot

class LandingRobot(composeRule: ComposeTestRule) : BaseRobot(composeRule = composeRule) {
    fun checkScreenContent() {
//        assertImage("carousel-image") Cant test due to canvas trying to draw too large image
        assertImage("new-globe-one-icon")
        assertText(text = "welcome to globeone", ignoreCase = true)
        assertText(
            text = "your digital life essentials right at your fingertips",
            ignoreCase = true
        )
        assertText(text = "join our community now!", ignoreCase = true)
        assertButton(text = "create an account", ignoreCase = true)
        assertButton(text = "log in", ignoreCase = true)
    }
}

fun ComposeTestRule.landingRobot(block: (LandingRobot) -> Unit): LandingRobot {
    return LandingRobot(this).apply(block)
}