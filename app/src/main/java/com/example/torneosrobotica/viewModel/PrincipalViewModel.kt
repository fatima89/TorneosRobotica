package com.example.torneosrobotica.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torneosrobotica.model.Torneo
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class PrincipalViewModel:ViewModel() {

    private val database = Firebase.database
    private var db: FirebaseFirestore = Firebase.firestore
    private val _torneo = MutableStateFlow<List<Torneo>>(emptyList())
    val torneo:StateFlow<List<Torneo>> = _torneo

    init {
//        repeat(20){
//
//            loadData()
//        }
        getTorneos()
    }
//    private fun loadData(){
//        val random = (1..1000).random()
//    val torneo = Torneo(name = "Random $random", description = "Soccer $random", image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4PNAn1y-EJG_kF2Elk0PRpQlAAHDKrw2J6w&s")
//    db.collection("torneos")
//        .add(torneo)
//    }

    private fun getTorneos(){
        viewModelScope.launch {
            val result:List<Torneo> =  withContext(Dispatchers.IO){
                getAllTorneos()
            }
            _torneo.value = result
        }
    }
    suspend fun getAllTorneos():List<Torneo>{
        return try {
        db.collection("torneos")
            .get()
            .await()
            .documents
            .mapNotNull { snapshot ->
                snapshot.toObject(Torneo::class.java)
            }
        }catch (e:Exception){
            Log.i("pequeciencia", e.toString())
            emptyList()
        }
    }
}