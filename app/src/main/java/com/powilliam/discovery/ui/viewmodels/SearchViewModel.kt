package com.powilliam.discovery.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.coroutines.await
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
    private var _developers: MutableLiveData<Array<GithubUser>> =
        MutableLiveData(arrayOf())
    val developers: LiveData<Array<GithubUser>> = _developers

    fun onSearchChange(value: String) = viewModelScope.launch {
        _login.value = value
    }

    fun onClearSearchValue() = viewModelScope.launch {
        _login.value = ""
    }

    fun onDeleteDeveloper(id: String) = viewModelScope.launch {
        _developers.value?.let { developers ->
            _developers.value = developers.filter { developer -> developer.id != id }
                .toTypedArray()
        }
    }

    fun doSearchByLogin() = viewModelScope.launch {
        _login.value?.let { login ->
            val query = GetUserByLoginQuery(login)
            val response = apollo.getClient()
                .query(query)
                .await()

            if (!response.hasErrors()) {
                response.data?.user?.let {user ->
                    _developers.value = arrayOf(
                        GithubUser(
                            id = user.id,
                            name = user.name ?: "",
                            bio = user.bio ?: "",
                            image = (user.avatarUrl ?: "") as String,
                        ),
                        *_developers.value!!
                    )
                }
            }
        }
    }
}