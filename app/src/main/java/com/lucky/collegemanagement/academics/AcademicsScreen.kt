// AcademicsScreen.kt
package com.lucky.collegemanagement.academics

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AcademicsScreen(viewModel: AcademicViewModel = viewModel()) {
    val subjects by viewModel.subjects.collectAsState()

    Scaffold(
        topBar = {
            Text(text = "Academics", color = Color.White, modifier = Modifier.padding(16.dp))
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF89CFF0),
        contentColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Semester 4", color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                items(subjects) { subject ->
                    SubjectRow(subject)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun SubjectRow(subject: Subject) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(text = subject.subjectName, modifier = Modifier.weight(1f))
        Text(text = "${subject.attendancePercentage}%", color = if (subject.attendancePercentage >= 80) Color.Green else Color.Red)
        Button(onClick = { /* Show details */ }) {
            Text(text = "Show Details")
        }
        Button(onClick = { /* Show handout */ }) {
            Text(text = "Show")
        }
        Button(onClick = { /* Show model question */ }) {
            Text(text = "Show")
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun AcademicsScreenPreview() {
    AcademicsScreen()
}
