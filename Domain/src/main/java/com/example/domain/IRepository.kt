package com.example.domain

interface IRepository {
    fun login()
    fun signUp()
    fun homePostList()
    fun postLike()
    fun postUnlike()
    fun uploadImage()
    fun createPost()
    fun userInfo()
    fun logout()
    fun myPosts()
    fun postDetail()
}