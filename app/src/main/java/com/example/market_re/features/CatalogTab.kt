package com.example.market_re.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.market_re.R
import com.example.market_re.model.CatalogButton
import com.example.market_re.model.HeaderMenu

object  CatalogTab : Tab {
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
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                HeaderMenu(
                    text = stringResource(R.string.catalog),
                    onClick = { navigator.push(ClothingScreen()) }
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
                        onClick = { navigator.push(ClothingScreen()) }
                    )

                    CatalogButton(
                        text = stringResource(R.string.footwear),
                        onClick = { navigator.push(ShoesScreen()) }
                    )

                    CatalogButton(
                        text = stringResource(R.string.accessories),
                        onClick = { navigator.push(AccessoriesScreen()) }
                    )
                }
            }
        )
    }

}


class ClothingScreen(): Screen{
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Одежда")
        }
    }
}


class ShoesScreen(): Screen{
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Одежда")
        }
    }
}

class AccessoriesScreen(): Screen{
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Одежда")
        }
    }
}



