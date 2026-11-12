package com.example.taskmanger.manger.data

import com.example.taskmanger.models.UserProfile
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class UserRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : UserRemoteDataSource {

    private val usersCollection =
        firestore.collection("users")

    override suspend fun createUser(user: UserProfile) {
        usersCollection
            .document(user.uid)
            .set(user)
            .await()
    }

    override suspend fun getUser(id: String): UserProfile? {
        val document = usersCollection
            .document(id)
            .get()
            .await()

        return document.toObject(UserProfile::class.java)
    }
}
