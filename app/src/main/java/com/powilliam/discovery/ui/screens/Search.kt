package com.powilliam.discovery.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.powilliam.discovery.domain.models.GithubUser
import com.powilliam.discovery.ui.components.LazyDevelopersList
import com.powilliam.discovery.ui.components.SearchTextField
import com.powilliam.discovery.ui.viewmodels.SearchViewModel

@ExperimentalFoundationApi
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel
) {
    val starredDevelopers by rememberSaveable { mutableStateOf(listOf(
        GithubUser(id = "1", name = "William Porto", bio = "Mobile developer at @naveteam", image = ""),
    )) }
    val developers by rememberSaveable { mutableStateOf(listOf(
        GithubUser(id = "2", name = "Lucas Gabriel", bio = "Mobile developer at @naveteam", image = ""),
        GithubUser(id = "3", name = "Gui Magnabosco", bio = "Mobile developer at @naveteam", image = "")
    )) }
    var search by rememberSaveable { mutableStateOf("") }

    searchViewModel.doSearchByLogin()

    Scaffold {
        Column {
            SearchTextField(
                value = search,
                onValueChange = { search = it },
                onClearValue = { search = "" }
            )
            LazyDevelopersList(
                data = mapOf(Pair("STARRED DEVELOPERS", starredDevelopers))
            )
            LazyDevelopersList(
                data = mapOf(Pair("MATCHES FOUND", developers))
            )
        }
    }
}