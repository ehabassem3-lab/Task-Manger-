package com.example.taskmanger.auth.data

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.example.taskmanger.auth
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
)  : AuthRemoteDataSource {
    override suspend fun signUp(email: String, password: String) {

    }

    override suspend fun signIn(email: String, password: String) {
       firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
           if(it.isSuccessful){
               Log.e("Logged In  ","Heeeeeeey")

           }else{
               Log.e(" Not Logged In  ","Neeeeeeey")
           }

       }
    }

}