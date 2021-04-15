package com.powilliam.discovery

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import com.powilliam.discovery.ui.screens.SearchScreen
import com.powilliam.discovery.ui.theme.DiscoveryTheme
import com.powilliam.discovery.ui.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val searchViewModel: SearchViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DiscoveryTheme {
                SearchScreen(
                    searchViewModel = searchViewModel
                )
            }
        }
    }
}