package com.example.coffeeapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.event.intent.EventIntent
import com.example.coffeeapp.event.states.StatesEvent
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SignUpViewModel : ViewModel() {
    private val _state = MutableStateFlow<StatesEvent>(StatesEvent.Idle)
    val state: StateFlow<StatesEvent> = _state

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun sendIntent(intent: EventIntent) {
        when (intent) {
            is EventIntent.SignUpIntent -> {
                viewModelScope.launch {
                    signUpFireBase(
                        intent.signUpModel.name,
                        intent.signUpModel.phone,
                        intent.signUpModel.email,
                        intent.signUpModel.password
                    )
                }
            }
        }
    }


    private suspend fun signUpFireBase(
        name: String,
        phone: String,
        email: String,
        password: String
    ) {
        _state.value = StatesEvent.Loading
        try {
            auth.createUserWithEmailAndPassword(email, password).await()
            _state.value = StatesEvent.Success("Signup Successful!")

        } catch (e: Exception) {
            _state.value = StatesEvent.Error(e.message ?: "Unknown Error")
        }
    }
}


