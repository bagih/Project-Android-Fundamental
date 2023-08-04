package com.bagih.intentexample.presentation

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ImageViewModel: ViewModel() {
    var imageUri: Uri? by mutableStateOf(null)
        private set


    fun updateUri(uri: Uri?){
        imageUri = uri
    }
}