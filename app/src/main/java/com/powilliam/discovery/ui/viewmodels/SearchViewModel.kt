package com.powilliam.discovery.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.powilliam.discovery.GetUserByLoginQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
//   private val apolloClient: ApolloClient
) : ViewModel() {
    fun doSearchByLogin() = viewModelScope.launch {
//        val query = GetUserByLoginQuery("powilliam")
//        val response = apolloClient
//            .query(query)
//            .await()
        Log.i("DoSearchByLogin", "a")
    }
}