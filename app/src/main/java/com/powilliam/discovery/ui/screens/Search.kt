package com.powilliam.discovery.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.powilliam.discovery.ui.components.Developer
import com.powilliam.discovery.ui.components.SearchTextField

@Composable
fun SearchScreen() {
    var search: String by rememberSaveable { mutableStateOf("") }

    Scaffold {
        Column {
            SearchTextField(
                value = search,
                onValueChange = { search = it },
                onClearValue = { search = "" }
            )
            Developer()
        }
    }
}