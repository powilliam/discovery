package com.powilliam.discovery.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.coroutines.await
import com.powilliam.discovery.GetUserByLoginQuery
import com.powilliam.discovery.domain.network.clients.Apollo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
   private val apollo: Apollo
) : ViewModel() {
    fun doSearchByLogin() = viewModelScope.launch {
        val query = GetUserByLoginQuery("powilliam")
        val response = apollo.getClient()
            .query(query)
            .await()
        Log.i("DoSearchByLogin", "${response.data}, ${response.errors}")
    }
}