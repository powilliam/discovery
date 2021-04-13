package com.powilliam.discovery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.powilliam.discovery.ui.screens.SearchScreen
import com.powilliam.discovery.ui.theme.DiscoveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DiscoveryTheme {
                SearchScreen()
            }
        }
    }
}