package com.lucky.collegemanagement.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = viewModel(), userEmail: String, navController: NavController) {
    val dashboardData by viewModel.dashboardData.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchDashboardData(userEmail)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF89CFF0))
    ) {
        TopBar()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(dashboardData.getAllData()) { (title, content, color) ->
                DashboardCard(title = title, content = content, color = color)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Dashboard", style = MaterialTheme.typography.titleLarge) },
        actions = {
            IconButton(onClick = { /* Handle profile icon click */ }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile Icon",
                    tint = Color.Black
                )
            }
        },
        modifier = Modifier.background(Color(0xFF89CFF0))
    )
}

@Composable
fun DashboardCard(title: String, content: String, color: Color) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { /* Handle click */ },
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    val mockData = DashboardData(
        facultyAdvisorName = "MR Chittaranjan Mohapatra",
        facultyAdvisorPhoneNumber = "9938068640",
        regdNo = "2201209219",
        program = "B.TECH",
        branch = "CSE",
        section = "B",
        timeTableLink = "Link to PDF",
        subjects = "0",
        lowAttendance = "0",
        highAttendance = "9",
        examScheduleToday = "0",
        examScheduleTomorrow = "0",
        resultInfo = "More info",
        libraryBooks = "0",
        libraryReturnToday = "0",
        libraryReturnWeek = "0",
        hostelRegistrationDate = "10-Aug-2023",
        hostelName = "Boys Residence-II",
        roomNumber = "745",
        bedNumber = "2",
        duesAmount = "193444.00",
        canteenRegistration = "Registration",
        onlineQuizExamInfo = "More info",
        onlineWrittenExamInfo = "More info",
        profileName = "SWARAJ MISHRA",
        profileMobile = "8260343536",
        profileEmail = "mswaraj46@gmail.com",
        holidaysYear = "2024-25",
        holidaysTotal = "25",
        feedbackStart = "14-May-2024",
        feedbackEnd = "30-May-2024",
        courseFeedbackStart = "25-May-2024",
        courseFeedbackEnd = "31-May-2024",
        practiceSchoolInfo = "More info",
        officialMailEmail = "cse.22bcsb72@silicon.ac.in",
        officialMailPassword = "nix2u4dz"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF89CFF0))
    ) {
        TopBar()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(mockData.getAllData()) { (title, content, color) ->
                DashboardCard(title = title, content = content, color = color)
            }
        }
    }
}
