package com.example.torneosrobotica.views

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore
import  com.example.torneosrobotica.model.Torneo
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import com.example.torneosrobotica.ui.theme.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import coil.compose.AsyncImage
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.clickable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.draw.clip
import com.example.torneosrobotica.viewModel.PrincipalViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState

@Composable
fun PrincipalView(viewModel: PrincipalViewModel = PrincipalViewModel()) {
    val torneos: State<List<Torneo>> = viewModel.torneo.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        Text(
            "Torneos",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {
               items(torneos.value){
                    TorneoItem(it)
               }
        }

    }
}
@Composable
fun TorneoItem(torneo: Torneo) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            model = torneo.image,
            contentDescription = "Imagen del Torneo",
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = torneo.name.orEmpty(), color = Color.White)
    }
}
//fun PrincipalView(db:FirebaseFirestore) {
//{
//    Button(onClick = {
//        createTorneo(db)
//    }) {
//        Text("Crear Torneo")
//    }
//}
//
//fun createTorneo(db: FirebaseFirestore){
//    val random = (1..1000).random()
//    val torneo = Torneo(name = "Random $random", description = "Soccer", image = "pelota")
//    db.collection("torneo")
//        .add(torneo)
//        .addOnSuccessListener {
//            Log.i("pequeciencia","Correcto")
//        }
//        .addOnFailureListener{
//            Log.i("pequeciencia","Falla")
//        }
//        .addOnCompleteListener {
//            Log.i("pequeciencia","Completado")
//        }
//}
