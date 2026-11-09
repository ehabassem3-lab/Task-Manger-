package com.example.taskmanger.manger.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskmanger.R
import com.example.taskmanger.manger.screens.tabs.home.HomeView
import com.example.taskmanger.manger.screens.tabs.profile.ProfileView
import com.example.taskmanger.manger.screens.tabs.settings.SettingsView
import com.example.taskmanger.manger.screens.tabs.tasks.TasksView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenView(
    navController: NavController,
) {


    data class tabItem(val index: Int, val icon: Int)

    val tabes = listOf(
        tabItem(0, R.drawable.ic_home),
        tabItem(1, R.drawable.ic_task),
        tabItem(2, R.drawable.ic_setting),
        tabItem(3, R.drawable.ic_profile)
    )


    val colorScheme = MaterialTheme.colorScheme
    val colorsNavItem = NavigationBarItemColors(
        selectedIconColor = colorScheme.background,
        selectedTextColor = Color.Transparent,
        unselectedIconColor = colorScheme.onBackground,
        unselectedTextColor = Color.Transparent,
        disabledIconColor = colorScheme.onBackground,
        disabledTextColor = Color.Transparent,
        selectedIndicatorColor = Color.Transparent,

        )
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {},
        bottomBar = {
            Surface(
                tonalElevation = 0.dp, // Removes the default M3 color overlay tint
                shadowElevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                color = colorScheme.background,
            ) {
                NavigationBar(
                    containerColor = Color.Transparent
                ) {
                    for (tab in tabes) {
                        val isSelected = tab.index == selectedIndex
                        NavigationBarItem(
                            modifier = Modifier.size(42.dp),
                            colors = colorsNavItem,
                            selected = isSelected,
                            icon = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(68.dp)
                                        .background(
                                            if (isSelected) colorScheme.onBackground else colorScheme.background,
                                            RoundedCornerShape(12.dp)
                                        )


                                ) {
                                    Icon(
                                        painterResource(tab.icon),
                                        contentDescription = "",
                                        modifier = Modifier.size(if (isSelected) 28.dp else 20.dp)
                                    )
                                }


                            },
                            onClick = {
                                selectedIndex = tab.index
                            }
                        )


                    }


                }

            }
        }
    ) {
        @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            when (selectedIndex) {
                0 -> HomeView(navController)
                1 -> TasksView(navController)
                2 -> SettingsView(navController)
                3 -> ProfileView(navController)
            }
        }


    }

}