package com.example.taskmanger.auth.data

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.example.taskmanger.auth
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
)  : AuthRemoteDataSource {
    override suspend fun signUp(email: String, password: String)  : Result<Unit> {
      return  Result.success(Unit)
    }

    override suspend fun signIn(email: String, password: String) : Result<Unit> {
        return    try {
            val request =  firebaseAuth.signInWithEmailAndPassword(email,password).await()

                  Result.success(Unit)

        }catch (e : Exception){
                   Result.failure(e)
        }








       }

    override suspend fun signOut(): Result<Unit> {
         return  try {
           firebaseAuth.signOut()
             Result.success(Unit)
        }catch (e : Throwable){
             Result.failure(e)
        }



    }
}

