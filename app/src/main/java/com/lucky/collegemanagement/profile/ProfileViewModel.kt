package com.lucky.collegemanagement.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _userProfile = MutableStateFlow(UserProfile())
    val userProfile: StateFlow<UserProfile> = _userProfile

    private val firestore = FirebaseFirestore.getInstance()

    fun getUserProfile(email: String) {
        viewModelScope.launch {
            val documentRef = firestore.collection("students").document(email)
            documentRef.get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        val userProfile = document.toObject(UserProfile::class.java)
                        _userProfile.value = userProfile ?: UserProfile()
                        Log.d("ProfileViewModel", "Profile data retrieved: $userProfile")
                    } else {
                        Log.e("ProfileViewModel", "No such document")
                        _userProfile.value = UserProfile()
                    }
                }
                .addOnFailureListener { exception ->
                    Log.e("ProfileViewModel", "Error fetching document: ", exception)
                }
        }
    }
}
