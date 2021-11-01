package com.example.data

import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk.getApplicationContext
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

class RepositoryImp {
    fun login() {
        val callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult>
            {
                override fun onCancel() {

                }

                override fun onError(error: FacebookException) {
                    Toast.makeText(getApplicationContext(),"${error.message}",LENGTH_LONG).show()
                    Log.d("Login onError ","${error.message}")
                }

                override fun onSuccess(result: LoginResult) {
                    AccessToken.setCurrentAccessToken(result.accessToken)
                }

            })
    }
}