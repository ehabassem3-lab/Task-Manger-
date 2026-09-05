package com.example.taskmanger.utilities

import kotlinx.serialization.Serializable

@Serializable
sealed class Resources< out  T>{
    data object Idle : Resources<Nothing>()
    data object Loading  : Resources<Nothing>()
    data class Success<out  T >(val data : T? = null) : Resources<T> ()
    data class Error(val exception :  Throwable , val message  : String? = exception.message) : Resources<Nothing> ()

 

}
