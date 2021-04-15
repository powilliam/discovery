package com.powilliam.discovery.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.livedata.*
import com.powilliam.discovery.domain.models.GithubUser
import com.powilliam.discovery.ui.components.LazyDevelopersList
import com.powilliam.discovery.ui.components.SearchTextField
import com.powilliam.discovery.ui.viewmodels.SearchViewModel

@ExperimentalFoundationApi
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel
) {
    val search by searchViewModel.login.observeAsState()
    val developers by searchViewModel.developers.observeAsState()

    Scaffold {
        Column {
            SearchTextField(
                value = search!!,
                onValueChange = { searchViewModel.onSearchChange(it) },
                onClearValue = { searchViewModel.onClearSearchValue() },
                onSearch = { searchViewModel.doSearchByLogin() }
            )
            LazyDevelopersList(
                data = mapOf(Pair("MATCHES FOUND", developers!!))
            )
        }
    }
}