package com.muliamaulana.mycomposetesting.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.muliamaulana.mycomposetesting.R
import com.muliamaulana.mycomposetesting.ui.theme.MyComposeTestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by muliamaulana on 21/01/24.
 */
class CalculatorAppTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MyComposeTestingTheme {
                CalculatorApp()
            }
        }
    }

    @Test
    fun calculate_are_of_rectangle_correct() {
        val activity = composeTestRule.activity
        composeTestRule.onNodeWithText(activity.getString(R.string.enter_length)).performTextInput("3")
        composeTestRule.onNodeWithText(activity.getString(R.string.enter_width)).performTextInput("4")
        composeTestRule.onNodeWithText(activity.getString(R.string.calculate)).performClick()
        composeTestRule.onNodeWithText(activity.getString(R.string.result, 12.0)).assertExists()
    }

    @Test
    fun wrong_input_not_calculated() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_length)).performTextInput("..3")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_width)).performTextInput("4")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.calculate)).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.result, 0.0)).assertExists()
    }
}