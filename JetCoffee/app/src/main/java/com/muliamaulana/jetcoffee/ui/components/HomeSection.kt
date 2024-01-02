package com.muliamaulana.jetcoffee.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by muliamaulana on 28/12/23.
 */

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        SectionText(title = title, modifier)
        content()
    }
}