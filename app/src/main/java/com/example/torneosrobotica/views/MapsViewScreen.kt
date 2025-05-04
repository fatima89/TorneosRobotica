package com.example.torneosrobotica.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.MapView
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.LatLng

@Composable
fun MapsViewScreen() {
    val context = LocalContext.current
    val mapView = remember {MapView(context)
        .apply { id = com.example.torneosrobotica.R.id.map_view_id}}

    LaunchedEffect(key1 = context) {
        MapsInitializer.initialize(context)
    }

    AndroidView(
        factory = {
            mapView.apply {
                onCreate(null)
                getMapAsync { googleMap ->
                    val cuenca = LatLng(-2.9005, -79.0044)
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cuenca, 15f))

                }
            }
        },
        modifier = Modifier.fillMaxSize(),
        update = {view ->
            view.onResume()
        },
        onRelease = {view ->
            view.onDestroy()
        }
    )
}