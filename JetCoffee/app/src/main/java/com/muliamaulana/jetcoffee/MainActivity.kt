package com.muliamaulana.jetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muliamaulana.jetcoffee.model.BottomBarItem
import com.muliamaulana.jetcoffee.model.Category
import com.muliamaulana.jetcoffee.model.Menu
import com.muliamaulana.jetcoffee.model.dummyBestSellerMenu
import com.muliamaulana.jetcoffee.model.dummyCategory
import com.muliamaulana.jetcoffee.model.dummyMenu
import com.muliamaulana.jetcoffee.ui.components.CategoryItem
import com.muliamaulana.jetcoffee.ui.components.HomeSection
import com.muliamaulana.jetcoffee.ui.components.MenuItem
import com.muliamaulana.jetcoffee.ui.components.Search
import com.muliamaulana.jetcoffee.ui.theme.JetCoffeeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeTheme(dynamicColor = false) {
                JetCoffeeApp()
            }
        }
    }

}

@Composable
fun JetCoffeeApp(modifier: Modifier = Modifier) {
    Scaffold(bottomBar = { BottomBar() }) { innerPadding ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Banner()
            HomeSection(
                title = stringResource(id = R.string.section_category),
                content = { CategoryRow() }
            )
            HomeSection(
                title = stringResource(id = R.string.section_favorite_menu),
                content = { MenuRow(listMenu = dummyMenu) }
            )
            HomeSection(
                title = stringResource(id = R.string.section_best_seller_menu),
                content = { MenuRow(listMenu = dummyBestSellerMenu) }
            )
        }
    }

}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )

        Search()
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {
    val data = dummyCategory
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(data, key = { it.textCategory }) { category: Category ->
            CategoryItem(category = category)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu)
        }
    }
}


@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    NavigationBar(
        contentColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        val navigationItems = listOf(
            BottomBarItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = stringResource(id = R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),
            BottomBarItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.AccountCircle
            ),
        )

        navigationItems.map {
            NavigationBarItem(
                selected = it.title == navigationItems[0].title,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
                label = {
                    Text(text = it.title)
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun JetCoffeeAppPreview() {
    JetCoffeeTheme {
        JetCoffeeApp()
    }
}