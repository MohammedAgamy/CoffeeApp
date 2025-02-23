package com.example.coffeeapp.event.intent

import com.example.coffeeapp.data.SignUpModel

sealed class EventIntent {
    data class SignUpIntent(val signUpModel: SignUpModel) : EventIntent()
}

