package com.wal.nycs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataViewModel(private val apiService: ApiService) : ViewModel() {

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = apiService.getData()
            if (response.isSuccessful) {
                // Handle response
            } else {
                // Handle error
            }
        }
    }
}