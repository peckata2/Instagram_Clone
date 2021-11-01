package com.example.domain.useCases

import com.example.domain.IRepository

class Login(private val repository:IRepository) {
    fun invoke()=repository.login()
}