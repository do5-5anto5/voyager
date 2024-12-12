package com.voyager.presenter.components.google_map

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.MarkerState.Companion.invoke
import com.google.maps.android.compose.rememberCameraPositionState
import com.voyager.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun GoogleMapUI(
    modifier: Modifier = Modifier,
    latitudeLongitude: LatLng,
    title: String
) {
    val markerState = MarkerState(position = latitudeLongitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latitudeLongitude, 15f)
    }
    GoogleMap(
        modifier = modifier
            .size(300.dp)
            .padding(vertical = 30.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Blue, CircleShape),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = markerState,
            title = title,
            snippet = stringResource(R.string.marker_description)
        )
    }
}