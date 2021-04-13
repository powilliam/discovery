package com.powilliam.discovery.ui.screens

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.powilliam.discovery.ui.components.SearchTextField

@Composable
fun SearchScreen() {
    var search: String by rememberSaveable { mutableStateOf("") }

    Scaffold {
        SearchTextField(
            value = search,
            onValueChange = { search = it },
            onClearValue = { search = "" }
        )
    }
}