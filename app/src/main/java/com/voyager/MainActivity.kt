package com.voyager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.voyager.core.navigation.host.AppNavHost
import com.voyager.ui.theme.VoyagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VoyagerTheme {
                AppNavHost(navHostController = rememberNavController())
            }
        }
    }
}