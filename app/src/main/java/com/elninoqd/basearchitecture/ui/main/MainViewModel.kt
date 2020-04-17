package com.elninoqd.basearchitecture.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.elninoqd.basearchitecture.data.model.User

class MainViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    val userId: String =
        savedStateHandle["uid"] ?: throw IllegalArgumentException("missing user id")
    val user: LiveData<User> = TODO()
}
