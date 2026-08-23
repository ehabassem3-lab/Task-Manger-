package com.example.taskmanger.utilities

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.taskmanger.App
import com.example.taskmanger.R
import com.example.taskmanger.ui.theme.AppTypography
import com.example.taskmanger.ui.theme.Primary

@Composable
fun CustomTextField(
    hintText: String,
    text: String,
    onValueChange: (String) -> Unit ,
    isSearchBar : Boolean = false ,
    onSearchClick: (() -> Unit)? = null,
    isPassword : Boolean = false ,
    isEdit : Boolean = false
){
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Row  (
        modifier = Modifier
            .padding(top  = 20.dp)
            .padding(horizontal = 12.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
            .width(350.dp),

        verticalAlignment = Alignment.CenterVertically  ,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        if (isSearchBar){
            Icon(
                painter =  painterResource(R.drawable.ic_search) ,
                contentDescription = "" ,
                modifier = Modifier.size(30.dp).padding(start =10.dp).clickable{
                    onSearchClick?.invoke()
                } ,
                tint = Primary
            )
        }
        TextField(
            modifier = Modifier.weight(1f),
            value = text,
            onValueChange = onValueChange,
            placeholder = {
                Text(text =
                    hintText ,
                    style =
                        AppTypography.labelSmall

                )
            },
            shape = RoundedCornerShape(15.dp),

            visualTransformation =
                if (isPassword && !passwordVisible)
                    PasswordVisualTransformation()
                else
                    VisualTransformation.None,

            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            textStyle = AppTypography.labelSmall ,

            )
        if (isPassword){
            Icon(
                painter =  painterResource(if (passwordVisible) R.drawable.ic_open_eye else R.drawable.ic_eye_closed ),
                contentDescription = "" ,
                modifier = Modifier.size(30.dp).padding(end = 10.dp).clickable{
                    passwordVisible = !passwordVisible
                } ,
                tint = Primary
            )
        }
        if (isEdit){
            Icon(
                painter = painterResource(R.drawable.ic_edit)  ,
                contentDescription = "" ,
                tint = Primary ,
                modifier = Modifier.size(30.dp).padding(end = 10.dp)
            )

        }

    }
}