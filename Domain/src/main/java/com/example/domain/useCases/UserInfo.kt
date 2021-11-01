package com.example.domain.useCases

import com.example.domain.IRepository

class UserInfo(private val repository:IRepository) {
    fun invoke()=repository.userInfo()
}