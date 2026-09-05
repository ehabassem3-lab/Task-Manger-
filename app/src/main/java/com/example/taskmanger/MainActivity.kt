    package com.example.taskmanger

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.runtime.Composable
    import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.example.taskmanger.auth.screens.signin.SignInView
    import com.example.taskmanger.auth.screens.signup.SignUpView
    import com.example.taskmanger.manger.screens.tabs.HomeTabView
    import com.example.taskmanger.routes.AppRoutes
    import com.example.taskmanger.ui.theme.TaskMangerTheme
    import com.google.firebase.Firebase
    import com.google.firebase.auth.FirebaseAuth
    import com.google.firebase.auth.auth
    import dagger.hilt.android.AndroidEntryPoint
     lateinit var auth: FirebaseAuth

    @AndroidEntryPoint

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            installSplashScreen()
            auth = Firebase.auth
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
//                val currentUser = auth.currentUser
//                if (currentUser == null) {
                    TaskMangerTheme {
                        App()
                    }
             }
               }

            }
//        }





    @Composable
    fun App( ){
        val navController = rememberNavController()
        NavHost(
            navController = navController ,
            startDestination= AppRoutes.SignInRoute
        ){
            composable <AppRoutes.HomeTabRoute>{
                HomeTabView()
            }
            composable <AppRoutes.SignInRoute>{
                SignInView(navController)
            }
            composable <AppRoutes.SignUpRoute>{
                SignUpView(navController)
            }

        }
    }



    //@Preview(showBackground = true)
    //@Composable
    //fun Preview() {
    //    CustomTextField(
    //        text = "ehab ",
    //        hintText = "ehab assem ",
    //        onValueChange = {},
    //        isSearchBar = true,
    //        onSearchClick = {} ,
    //        isPassword = true
    //    )
    //
    //
    //}


