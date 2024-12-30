package com.example.market_re

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.market_re.ui.theme.PurpleGrey40

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            TabNavigator(HomeTab) {
                Scaffold(
                    content = {
                        CurrentTab()
                    },
                    bottomBar = {
                        BottomNavigation {

                            TabNavigationItem(HomeTab)
                            TabNavigationItem(ShopTab)
                            TabNavigationItem(FavoriteTab)
                            TabNavigationItem(CatalogTab)
                            TabNavigationItem(AccountTab)
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            Image(painter = tab.options.icon?: rememberVectorPainter(Icons.Default.Warning),
                contentDescription = tab.options.title,
                modifier = Modifier.background(color = PurpleGrey40).fillMaxWidth().padding(8.dp).size(50.dp))
        }
    )
}
