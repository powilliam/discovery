package com.powilliam.discovery.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.powilliam.discovery.ui.components.LazyDevelopersList
import com.powilliam.discovery.ui.components.SearchTextField
import com.powilliam.discovery.ui.viewmodels.SearchViewModel

@ExperimentalFoundationApi
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel
) {
    val loading by searchViewModel.loading.observeAsState()
    val search by searchViewModel.login.observeAsState()
    val developers by searchViewModel.developers.observeAsState()

    Scaffold {
        Column {
            SearchTextField(
                value = search!!,
                onValueChange = { value -> searchViewModel.onSearchChange(value) },
                onClearValue = { searchViewModel.onClearSearchValue() },
                onSearch = { searchViewModel.doSearchByLogin() }
            )

            when (loading) {
                true -> {
                    LinearProgressIndicator(
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )
                }
            }

            LazyDevelopersList(
                data = mapOf(Pair("MATCHES FOUND", developers!!)),
                onDeleteOne = { id -> searchViewModel.onDeleteDeveloper(id) }
            )
        }
    }
}