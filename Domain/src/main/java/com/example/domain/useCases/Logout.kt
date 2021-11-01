package com.example.domain.useCases

import com.example.domain.IRepository

class Logout(private val repository:IRepository) {
    fun invoke()=repository.logout()
}