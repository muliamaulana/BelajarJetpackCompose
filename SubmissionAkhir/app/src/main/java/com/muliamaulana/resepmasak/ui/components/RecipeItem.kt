package com.muliamaulana.resepmasak.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Info
import androidx.compose.material.icons.twotone.Notifications
import androidx.compose.material.icons.twotone.ThumbUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.muliamaulana.resepmasak.model.Recipe

/**
 * Created by muliamaulana on 29/01/24.
 */

@Composable
fun RecipeItem(
    recipe: Recipe?,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column {
            AsyncImage(
                model = recipe?.thumbnail,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LabelItem(recipe?.difficulty, Icons.TwoTone.ThumbUp)
                LabelItem(recipe?.servings, Icons.TwoTone.Info)
                LabelItem(recipe?.times, Icons.TwoTone.Notifications)
            }

            Text(
                text = recipe?.title ?: "-",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                maxLines = 3,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}

@Composable
fun LabelItem(
    label: String?,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    AssistChip(
        onClick = {},
        label = { Text(label ?: "-") },
        leadingIcon = {
            Icon(
                icon,
                contentDescription = "Localized description",
                modifier
                    .size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun RecipeItemPreview() {
    MaterialTheme {
        RecipeItem(
            Recipe(
                id = "resep-bakcang-daging-jamur",
                title = "Resep Bakcang Daging Jamur, Sarapan Istimewa untuk Weekend",
                times = "4jam",
                difficulty = "Mudah",
                servings = "6 Porsi",
                ingredient = null,
                step = null,
                thumbnail = "https://www.masakapahariini.com/wp-content/uploads/2021/11/resep-bakcang-400x240.jpg"
            ),
        )
    }
}