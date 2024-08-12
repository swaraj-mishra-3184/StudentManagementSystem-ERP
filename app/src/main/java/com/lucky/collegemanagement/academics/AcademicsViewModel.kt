package com.lucky.collegemanagement.academics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class AcademicViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()

    private val _subjects = MutableStateFlow<List<Subject>>(emptyList())
    val subjects: StateFlow<List<Subject>> get() = _subjects

    init {
        fetchSubjects()
    }

    private fun fetchSubjects() {
        viewModelScope.launch {
            try {
                val snapshot = firestore.collection("subjects").get().await()
                val subjectsList = snapshot.documents.mapNotNull { it.toObject(Subject::class.java) }
                _subjects.value = subjectsList
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
