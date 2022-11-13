package com.example.koing

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Auth:Application() {
    companion object{
        lateinit var auth: FirebaseAuth
        var email:String? = null
        fun checkAuth(): Boolean{
            var currentUser = auth.currentUser
            return currentUser?.let{
                email = currentUser.email
                currentUser.isEmailVerified
            }?: let{
                false
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        auth = Firebase.auth
    }
}