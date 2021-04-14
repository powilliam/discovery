package com.powilliam.discovery.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.powilliam.discovery.GetUserByLoginQuery
import com.powilliam.discovery.domain.models.GithubUser
import com.powilliam.discovery.domain.network.clients.Apollo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
   private val apollo: Apollo
) : ViewModel() {

    private var _login: MutableLiveData<String> = MutableLiveData("")
    val login: LiveData<String> = _login
    private var _developers: MutableLiveData<MutableList<GithubUser>> =
        MutableLiveData(mutableListOf())
    val developers: LiveData<MutableList<GithubUser>> = _developers

    fun onSearchChange(value: String) = viewModelScope.launch {
        _login.value = value
    }

    fun onClearSearchValue() = viewModelScope.launch {
        _login.value = ""
    }

    fun doSearchByLogin() = viewModelScope.launch {
        _login.value?.let { login ->
            val query = GetUserByLoginQuery(login)
            apollo.getClient()
                .query(query)
                .enqueue(object : ApolloCall.Callback<GetUserByLoginQuery.Data>() {
                    override fun onResponse(response: Response<GetUserByLoginQuery.Data>) {
                        Log.d("OnResponse", response.toString())
                        if (!response.hasErrors()) {
                            response.data?.user?.let {user ->
                                _developers.value?.add(
                                    GithubUser(
                                        id = user.id,
                                        name = user.name ?: "",
                                        bio = user.bio ?: "",
                                        image = (user.avatarUrl ?: "") as String,
                                    )
                                )
                            }
                        }
                    }

                    override fun onFailure(e: ApolloException) {
                        Log.e("DoSearchByLogin", e.toString())
                    }
                })
        }
    }
}