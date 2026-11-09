package com.example.taskmanger.manger.screens.tabs.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskmanger.auth

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController) {
    val colorScheme = MaterialTheme.colorScheme
    val user = auth.currentUser
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.onBackground)
            .padding(start = 5.dp, end = 5.dp, top = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 30.dp)
                .fillMaxWidth()
                .height(80.dp)
                .background(colorScheme.background, RoundedCornerShape(12.dp)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                user?.email ?: "sssssssss",
                modifier = Modifier.size(40.dp),
                color = colorScheme.onBackground
            )

        }

    }

}