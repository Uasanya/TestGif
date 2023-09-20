package com.example.testgif.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testgif.data.model.Gif
import com.example.testgif.data.repository.GifRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GifViewModel @Inject constructor(private val gifRepository: GifRepository) : ViewModel() {

    private val _gifLiveData = MutableLiveData<List<Gif>>()
    val gifLiveData: LiveData<List<Gif>>
        get() = _gifLiveData

    fun getGifs() {
        viewModelScope.launch {
            try {
                val gifs = gifRepository.loadGifs().data
                _gifLiveData.value = gifs
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}