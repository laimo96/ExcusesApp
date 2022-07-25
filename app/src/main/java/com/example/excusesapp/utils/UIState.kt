package com.example.excusesapp.utils

sealed class UIState{
    object LOADING: UIState()
    data class SUCCESS(val response: Any): UIState()
    data class ERROR (val error: Exception): UIState()
}

