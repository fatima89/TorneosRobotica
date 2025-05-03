package com.example.torneosrobotica.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torneosrobotica.model.Torneo
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

    private lateinit var db: FirebaseFirestore
    private val _torneo = MutableStateFlow<List<Torneo>>(emptyList())
    val torneo:StateFlow<List<Torneo>> = _torneo

    init {
        db = Firebase.firestore
        getTorneos()
    }

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