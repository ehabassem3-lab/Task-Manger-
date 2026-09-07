package com.example.taskmanger.auth.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskmanger.R
import com.example.taskmanger.auth
import com.example.taskmanger.routes.AppRoutes
import com.example.taskmanger.ui.theme.Secondary
import kotlinx.coroutines.delay

@Composable
fun SplashScreenView(navController: NavController){
    val logoScale = remember { Animatable(1f) }
    val textScale = remember { Animatable(0f) }
    var moveLogo by remember { mutableStateOf(false) }
    var showText by remember { mutableStateOf(false) }
    val logoOffset by animateDpAsState(
        targetValue = if (moveLogo) (-90).dp else 0.dp,
        animationSpec = tween(700),
        label = ""
    )


    LaunchedEffect(Unit) {
        logoScale.animateTo(
            targetValue = 2f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
        moveLogo = true
        delay(300)
        showText = true


        textScale.animateTo(
            targetValue = 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )

        delay(3000)
    }

    LaunchedEffect(Unit) {
        val currentUser = auth.currentUser
        if (currentUser == null) {
            delay(3000)
            navController.navigate(AppRoutes.SignInRoute)
        } else {
            delay(3000)

            navController.navigate(AppRoutes.HomeTabRoute)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            painter = painterResource(R.drawable.ic_sign_in),
            contentDescription = null,
//            tint = Secondary,
            modifier = Modifier
                .offset(y = logoOffset)
                .size(225.dp * logoScale.value)
        )

        if (showText) {

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Task Manger",

                color = colorScheme.onBackground,
                modifier = Modifier
                    .offset(y = -180.dp)
                    .graphicsLayer {
                        scaleX = textScale.value
                        scaleY = textScale.value
                    }
            )
        }
    }




}