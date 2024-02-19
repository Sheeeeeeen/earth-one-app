package ph.com.earth.user

import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule

abstract class BaseRobot(private val composeRule: ComposeTestRule) {

    // Text
    fun assertText(text: String, ignoreCase: Boolean = false, substring: Boolean = false) =
        composeRule.onNode(hasText(text, ignoreCase = ignoreCase, substring = substring))
            .assertExists()

    // Button
    fun assertButton(text: String, ignoreCase: Boolean = false) =
        composeRule.onNode(hasText(text = text, ignoreCase = ignoreCase).and(hasClickAction()))
            .assertExists()

    // Image
    fun assertImage(description: String) =
        composeRule.onNode(hasContentDescription(description)).assertExists()
}