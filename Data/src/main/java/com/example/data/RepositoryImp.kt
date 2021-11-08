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
import android.os.Bundle

import com.facebook.GraphResponse

import org.json.JSONObject

import com.facebook.GraphRequest
import com.facebook.GraphRequest.GraphJSONObjectCallback
import io.reactivex.Observable
import io.reactivex.Single


class RepositoryImp {
    fun login() {
        val callbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                override fun onCancel() {

                }

                override fun onError(error: FacebookException) {
                    Toast.makeText(getApplicationContext(), "${error.message}", LENGTH_LONG).show()
                    Log.d("Login onError ", "${error.message}")
                }

                override fun onSuccess(result: LoginResult) {
                    AccessToken.setCurrentAccessToken(result.accessToken)
                }

            })
    }

    fun getPosts(accessToken: AccessToken) {
        val request = GraphRequest.newMeRequest(
            accessToken,
            object : GraphJSONObjectCallback {
                override fun onCompleted(obj: JSONObject?, response: GraphResponse?) {
//                    return Observable<>
                }
            })

        val parameters = Bundle()
        parameters.putString("fields", "id,feed{description,attachments{media}}")
        request.parameters = parameters
        request.executeAsync()
    }

    fun getUserMedia(userid: String, accessToken: String): Single<List<Media>> {
        return Retrofit.create("https://graph.instagram.com/").getUserMedia(userid, accessToken)
            .flatMap {
                Single.create { emitter ->
                    if (it.data.isNullOrEmpty())
                        emitter.onError(Throwable("No user media"))
                    else
                        emitter.onSuccess(it.data)
                }
            }
    }

    fun instagramAuth(
        clientID: String,
        permissions: String,
        redirectURI: String,
        responseType: String
    ): Single<String> {
        return Retrofit.create("https://api.instagram.com/")
            .instagramAuth(clientID, permissions, redirectURI, responseType)
    }

//    GraphRequest request = GraphRequest.newMeRequest(
//    accessToken,
//    new GraphRequest.GraphJSONObjectCallback() {
//        @Override
//        public void onCompleted(JSONObject object, GraphResponse response) {
//            // Insert your code here
//        }
//    });
//
//    Bundle parameters = new Bundle();
//    parameters.putString("fields", "id,feed{description,attachments{media}}");
//    request.setParameters(parameters);
//    request.executeAsync();
}