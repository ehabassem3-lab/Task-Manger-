package com.example.taskmanger.auth.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.taskmanger.R
import com.example.taskmanger.ui.theme.AppTypography
import com.example.taskmanger.ui.theme.Primary
import com.example.taskmanger.ui.theme.Secondary
import com.example.taskmanger.utilities.CustomTextField
import com.example.taskmanger.utilities.DropDownMenu

@Composable
fun SignUpView(
    navController: NavController ,
    viewModel: SignUpViewModel = hiltViewModel()
){
    val state = viewModel.state.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
            .padding(vertical = 30.dp , horizontal = 30.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            painter = painterResource(R.drawable.ic_sign_in),
            contentDescription = "" ,
            tint = Secondary ,
            modifier = Modifier.padding(vertical = 20.dp).size(200.dp)
        )
        Text(
            "Task Manger " ,
            style = AppTypography.headlineLarge ,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Text(
            "Email" ,
            modifier = Modifier.offset(x = -150.dp).padding(vertical = 5.dp) ,
            style = AppTypography.bodyLarge.copy(fontSize = 22.sp)
        )

        CustomTextField(
             text = state.email ,
            onValueChange = {viewModel.onEvent(SignUpEvents.onEmailChange(it))}  ,
            hintText = "enter your email "

        )
        Text(
            "Password" ,
            modifier = Modifier.offset(x = -140.dp).padding(top = 10.dp) ,
            style = AppTypography.bodyLarge.copy(fontSize = 22.sp)
        )

        CustomTextField(
            text = state.email ,
            onValueChange = {viewModel.onEvent(SignUpEvents.onPassWordChange(it))}  ,
            hintText = "enter your password "

        )
        Text(
            "Phone" ,
            modifier = Modifier.offset(x = -160.dp).padding(top = 10.dp) ,
            style = AppTypography.bodyLarge.copy(fontSize = 22.sp)
        )

        CustomTextField(
            text = state.email ,
            onValueChange = {viewModel.onEvent(SignUpEvents.onPhoneChange(it))}  ,
            hintText = "enter your phone Number "

        )
        Text(
            "Role " ,
            modifier = Modifier.offset(x = -160.dp).padding(top = 10.dp) ,
            style = AppTypography.bodyLarge.copy(fontSize = 22.sp)
        )
        DropDownMenu(option = listOf(Roles.STAFF , Roles.MANAGER))




    }

}