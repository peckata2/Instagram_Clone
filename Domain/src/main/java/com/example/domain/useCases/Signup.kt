package com.example.domain.useCases

import com.example.domain.IRepository

class Signup(private val repository:IRepository) {
    fun invoke()=repository.signUp()
}