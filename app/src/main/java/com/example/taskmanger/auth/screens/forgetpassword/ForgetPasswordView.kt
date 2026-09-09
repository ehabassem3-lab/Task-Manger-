package com.example.taskmanger.auth.screens.forgetpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.taskmanger.R
import com.example.taskmanger.auth.screens.signin.SignInEvents
import com.example.taskmanger.ui.theme.AppTypography
import com.example.taskmanger.ui.theme.Primary
import com.example.taskmanger.ui.theme.Secondary
import com.example.taskmanger.utilities.CustomTextField

@Composable
fun ForgetPasswordView(
    navController: NavController ,
    viewModel: ForgetPasswordViewModel  = hiltViewModel()
){
    val state = viewModel.state.collectAsStateWithLifecycle().value





    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
            .padding(top = 50.dp, bottom = 50.dp, start = 20.dp, end = 20.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_sign_in ),
            contentDescription = "" ,
            tint = Secondary ,
            modifier = Modifier
                .padding(top = 60.dp)
                .size(200.dp)

        )
        Text(
            "Task Manger " ,
            style = AppTypography.headlineLarge ,
            modifier = Modifier.padding(top = 30.dp)
        )
        CustomTextField(
            hintText = "Enter  Your  Email ",
            text = state.email,
            onValueChange ={
                viewModel.onEvent(ForgetPasswordEvents.onEmailChange(it))
            }
        )
        Box(
            modifier = Modifier
                .padding(top = 30.dp)
                .width(350.dp)
                .height(60.dp)
                .background(
                    Secondary,
                    RoundedCornerShape(12.dp)
                )
                .clickable {

                } ,

            contentAlignment = Alignment.Center
        ){
            Text(
                "Reset Password" ,
                style = AppTypography.bodyMedium.copy(fontSize = 26.sp , fontWeight = FontWeight.Bold , color = Primary)
            )

        }

    }

}