package com.example.taskmanger.manger.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.taskmanger.R
import com.example.taskmanger.ui.theme.Primary

@Composable
fun MainScreenView(
    navController: NavController ,
){
    data class tabItem (val index : Int  , val icon : Int)
    val tabes = listOf(
       tabItem(0 , R.drawable.ic_home)  ,
        tabItem(1 , R.drawable.ic_task),
        tabItem(2 , R.drawable.ic_setting),
        tabItem(3 , R.drawable.ic_profile)
    )

      var selectedIndex by rememberSaveable { mutableIntStateOf(0) }


    Scaffold(
        topBar = {} ,
        bottomBar = {
            NavigationBar() {
                for (tab in tabes){
                    val isSelected = tab.index == selectedIndex
                    NavigationBarItem(
                        selected = isSelected ,
                        icon = { tab.icon } ,
                        onClick = {
                            selectedIndex = tab.index
                        }
                    )


                }

            }
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Primary)
                .padding(it)
        ){


        }
    }

}