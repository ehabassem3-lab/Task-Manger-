package com.example.taskmanger.manger.screens

import android.provider.CalendarContract
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskmanger.R
import com.example.taskmanger.manger.screens.tabs.HomeView
import com.example.taskmanger.manger.screens.tabs.ProfileView
import com.example.taskmanger.manger.screens.tabs.SettingsView
import com.example.taskmanger.manger.screens.tabs.TasksView
import com.example.taskmanger.ui.theme.Primary
import com.example.taskmanger.ui.theme.Secondary
import kotlinx.coroutines.flow.combineTransform

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
    val colorsNavItem  = NavigationBarItemColors(
        selectedIconColor = Secondary,
        selectedTextColor = Color.Transparent,
        selectedIndicatorColor = Color.Transparent,
        unselectedIconColor = Primary,
        unselectedTextColor = Color.Transparent,
        disabledIconColor = Primary,
        disabledTextColor = Color.Transparent ,


    )



      var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        topBar = {} ,
        bottomBar = {


                NavigationBar (
                    modifier = Modifier
                     .clip(RoundedCornerShape(18.dp)),
                    contentColor = Color.White,
                       containerColor = Color.White



                ) {
                    for (tab in tabes){
                        val isSelected = tab.index == selectedIndex
                        NavigationBarItem(
                            modifier = Modifier.size(42.dp),
                            colors = colorsNavItem,
                            selected = isSelected ,
                            icon = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(68.dp)
                                        .background(
                                            if (isSelected)    Primary  else Secondary, RoundedCornerShape(12.dp)


                                        )


                                ){
                                    Icon(
                                        painterResource(tab.icon) ,
                                        contentDescription = "" ,
                                        modifier = Modifier.size(if (isSelected) 28.dp else 20.dp)
                                    )
                                }


                            } ,
                            onClick = {
                                selectedIndex = tab.index
                            }
                        )


                    }


            }

        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it).background(Color.Transparent)
        ) {
            when(selectedIndex){
                0 -> HomeView(navController)
            1-> TasksView(navController)
            2 -> SettingsView(navController)
            3 -> ProfileView(navController)
            }
        }


    }

}