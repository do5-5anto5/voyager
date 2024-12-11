package com.voyager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.voyager.presenter.screen.ride_request.screen.RideRequestScreen
import com.voyager.ui.theme.VoyagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VoyagerTheme {
                RideRequestScreen()
            }
        }
    }
}