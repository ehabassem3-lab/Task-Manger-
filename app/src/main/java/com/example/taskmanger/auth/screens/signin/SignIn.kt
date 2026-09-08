package com.example.taskmanger.auth.screens.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.taskmanger.R
import com.example.taskmanger.routes.AppRoutes
import com.example.taskmanger.ui.theme.AppTypography
import com.example.taskmanger.ui.theme.Primary
import com.example.taskmanger.ui.theme.Secondary
import com.example.taskmanger.utilities.CustomTextField
import com.example.taskmanger.utilities.Resources

@Composable
fun SignInView(
    navController: NavController ,
      viewModel: SignInViewModel = hiltViewModel()
){
    val state =  viewModel.state.collectAsStateWithLifecycle().value
    LaunchedEffect(state.signInApi) {
        when(state.signInApi){
            is Resources.Error -> {}
            Resources.Idle -> {

            }
            Resources.Loading -> {

            }
            is Resources.Success<*> -> {
                navController.navigate(AppRoutes.HomeTabRoute)
            }
        }

    }
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
        Text(
            "Enter your email " ,
            modifier = Modifier.padding(end = 200.dp, top = 10.dp)
        )
        CustomTextField(
            hintText = "enter your email",
            text = state.email,
            onValueChange = {viewModel.onEvent(SignInEvents.onEmailChange(it))},
        )
        Text(
            "Enter your password " ,
            modifier = Modifier.padding(end = 200.dp, top = 20.dp)
        )
        CustomTextField(
            hintText = "enter your password",
            text = state.password,
            onValueChange = {viewModel.onEvent(SignInEvents.onPassWordChange(it))},
            isPassword = true
        )
        Text(
            "Forget PassWord" ,
            modifier = Modifier
                .padding(start = 150.dp, top = 10.dp)
                .clickable {

                },
            style =  AppTypography.bodyMedium.copy(fontSize = 18.sp , color = Secondary  , fontWeight = FontWeight.Normal)

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
                    viewModel.onEvent(SignInEvents.SignInClick(state.email, state.password))
                } ,

            contentAlignment = Alignment.Center
        ){
            if(state.signInApi is Resources.Loading ){
                CircularProgressIndicator(color = Primary)
            }else{
                Text(
                    "Log In " ,
                    style = AppTypography.bodyMedium.copy(fontSize = 26.sp , fontWeight = FontWeight.Bold , color = Primary)
                )
            }


        }

        Text(
            "Dont Have An Account? Create Account" ,
            modifier = Modifier
                .padding(vertical = 5.dp)
                .clickable {
                    navController.navigate(AppRoutes.SignUpRoute)

                },
             style =  AppTypography.bodyMedium.copy(fontSize = 16.sp , color = Secondary  , fontWeight = FontWeight.Bold)

        )




    }

}