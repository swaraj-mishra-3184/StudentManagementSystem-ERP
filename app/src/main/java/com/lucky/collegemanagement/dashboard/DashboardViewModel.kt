package com.lucky.collegemanagement.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DashboardViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()

    private val _dashboardData = MutableStateFlow(DashboardData())
    val dashboardData: StateFlow<DashboardData> get() = _dashboardData

    fun fetchDashboardData(email: String) {
        viewModelScope.launch {
            try {
                val document = firestore.collection("students").document(email).get().await()
                val data = document.toObject(DashboardData::class.java)
                if (data != null) {
                    _dashboardData.value = data
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
