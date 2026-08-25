package com.example.taskmanger.utilities

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanger.R
import com.example.taskmanger.auth.screens.signup.Roles
import com.example.taskmanger.ui.theme.Secondary

@Composable
fun DropDownMenu(
    option: List<Roles>

) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(option.first()) }
    Box(
        modifier = Modifier
            .width(350.dp)
            .height(60.dp)
            .background(Color.Transparent)
            .border(width = 2.dp , shape = RoundedCornerShape(12.dp) , color = Secondary)
            .padding(16.dp)
    ) {

             Icon(
                 painter = painterResource(R.drawable.ic_arrow_down) ,
                 contentDescription = "" ,
                 tint = Secondary ,
                 modifier = Modifier.offset(x = 290.dp).clickable{
                     expanded  = !expanded
                 }
             )
        Text(
            text = selectedOption.toString(),
            color = Secondary ,

        )
              DropdownMenu(
                  expanded =  expanded ,
                  onDismissRequest = {
                      expanded = !expanded
                  }
              ) {
                 for ( i in 0 until  option.size){
                     DropdownMenuItem(
                         text = {
                             Text(option[i].toString())
                         },
                         onClick = {
                             selectedOption = option[i]
                             expanded = false

                         }
                     )
                 }
              }






//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            DropdownMenuItem(
//                text = { Text("Option 1") },
//                onClick = { }
//            )
//            DropdownMenuItem(
//                text = { Text("Option 2") },
//                onClick = {  }
//            )
//        }
    }
}


@Composable
@Preview
fun slider(){
    DropDownMenu(
        listOf(Roles.STAFF , Roles.MANAGER)
    )
}