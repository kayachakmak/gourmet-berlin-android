package com.example.gourmetberlin.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gourmetberlin.ui.model.Coordinates
import com.example.gourmetberlin.ui.model.Restaurant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class MainViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Restaurant>>()
    val data: LiveData<List<Restaurant>> get() = _data

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun fetchData(filterType: String, isAnimalFriendly: Boolean, isChildFriendly: Boolean) {
        _isLoading.value = true

        viewModelScope.launch {
            val params = mutableListOf<String>()
            if (filterType.isNotEmpty()) params.add("type=$filterType")
            if (isAnimalFriendly) params.add("animalFriendly=true")
            if (isChildFriendly) params.add("childFriendly=true")

            val queryString = params.joinToString("&")
            val baseUrl = "http://10.0.2.2:8000/api/" // Android emulator localhost access
            val urlString = "$baseUrl?$queryString"

            withContext(Dispatchers.IO) {
                try {
                    val url = URL(urlString)
                    val connection = url.openConnection() as HttpURLConnection
                    connection.requestMethod = "GET"
                    connection.connect()

                    if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                        // Read data and parse it here
                        // For demonstration, we'll use dummy data
                        val dummyData = listOf(
                            Restaurant(
                                name = "Dummy Restaurant 1",
                                type = "Italian",
                                isAnimalFriendly = true,
                                isChildFriendly = true,
                                menu = "http://example.com/menu",
                                link = "http://example.com",
                                address = "123 Main St, Berlin",
                                coordinates = Coordinates(lat = 52.5200, long = 13.4050)
                            ),
                            Restaurant(
                                name = "Dummy Restaurant 2",
                                type = "Mexican",
                                isAnimalFriendly = false,
                                isChildFriendly = true,
                                menu = "http://example.com/menu",
                                link = "http://example.com",
                                address = "456 Main St, Berlin",
                                coordinates = Coordinates(lat = 52.5200, long = 13.4050)
                            )
                        )
                        _data.postValue(dummyData)
                    } else {
                        _data.postValue(emptyList())
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    _data.postValue(emptyList())
                } finally {
                    _isLoading.postValue(false)
                }
            }
        }
    }
}
