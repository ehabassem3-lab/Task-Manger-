package com.example.taskmanger.auth.data

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.example.taskmanger.auth
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(

)  : AuthRemoteDataSource {
    override suspend fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                val user = auth.currentUser
            }else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)

            }


        }

    }

}