package com.example.market_re

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions


class CatalogTab() : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Catalog"
            val icon = rememberVectorPainter(Icons.Default.ShoppingCart)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }
    @Composable
    override fun Content() {
        Navigator(CatalogScreen())
    }
}

class CatalogScreen(): Screen{
    @Composable
    override fun Content() {
        val navigator = rememberNavigator()
        Scaffold(
            topBar = {
                HeaderMenu(
                    text = stringResource(R.string.catalog),
                    onClick = { navigator.popBackStack() }
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(paddingValues)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CatalogButton(
                        text = stringResource(R.string.clothes),
                        onClick = { navigator.navigate(ClothingScreen()) }
                    )

                    CatalogButton(
                        text = stringResource(R.string.footwear),
                        onClick = { navigator.navigate(ShoesScreen()) }
                    )

                    CatalogButton(
                        text = stringResource(R.string.accessories),
                        onClick = { navigator.navigate(AccessoriesScreen()) }
                    )
                }
            }
        )
    }

}
@Composable
fun CatalogButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
}




@Composable
fun HeaderMenu(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onClick() },
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Назад",
                tint = Color.Black
            )
        }

        Text(
            text = text,
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.Black
            ),
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        )
    }
}


@Composable
fun ClothingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Одежда")
    }
}

@Composable
fun ShoesScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Обувь")
    }
}

@Composable
fun AccessoriesScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Аксессуары")
    }
}
