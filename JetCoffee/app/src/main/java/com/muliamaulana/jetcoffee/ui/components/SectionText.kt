package com.muliamaulana.jetcoffee.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Created by muliamaulana on 28/12/23.
 */

@Composable
fun SectionText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )

}