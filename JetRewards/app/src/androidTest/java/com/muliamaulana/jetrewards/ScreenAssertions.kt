package com.muliamaulana.jetrewards

import androidx.navigation.NavController
import org.junit.Assert.assertEquals

/**
 * Created by muliamaulana on 25/01/24.
 */

fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}