package com.lucky.collegemanagement.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileScreen(
    email: String,
    viewModel: ProfileViewModel = viewModel()
) {
    val userProfile by viewModel.userProfile.collectAsState()

    LaunchedEffect(email) {
        viewModel.getUserProfile(email)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0073E6),
                        Color(0xFF89CFF0)
                    )
                )
            )
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clip(AbsoluteRoundedCornerShape(15.dp))
                .shadow(10.dp)
                .padding(0.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFD0EFFF),
                contentColor = Color.Black,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.LightGray
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "User Profile",
                    style = MaterialTheme.typography.headlineLarge,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Serif,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .width(80.dp)
                        .clip(AbsoluteRoundedCornerShape(12.dp)),
                    thickness = 5.dp,
                    color = Color(0xFF0073E6)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF005BB5),
                        contentColor = Color.Black,
                        disabledContainerColor = Color.White,
                        disabledContentColor = Color.LightGray
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF00336F)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Personal Information",
                            style = MaterialTheme.typography.headlineMedium,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding(5.dp),
                            color = Color.LightGray
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    HorizontalDivider()
                    Text(
                        text = "Name: ${userProfile.name}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Branch: ${userProfile.branch}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Course: ${userProfile.course}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Gender: ${userProfile.gender}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Email: ${userProfile.officialMailId}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Phone: ${userProfile.phoneNumber}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Section: ${userProfile.section}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "SIC: ${userProfile.sic}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val mockUserProfile = UserProfile(
        branch = "Computer Science",
        course = "B.Tech",
        gender = "Male",
        name = "John Doe",
        officialMailId = "johndoe@college.edu",
        phoneNumber = "1234567890",
        section = "A",
        sic = "123456"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0073E6),
                        Color(0xFF89CFF0)
                    )
                )
            )
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clip(AbsoluteRoundedCornerShape(15.dp))
                .shadow(10.dp)
                .padding(0.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFD0EFFF),
                contentColor = Color.Black,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.LightGray
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "User Profile",
                    style = MaterialTheme.typography.headlineLarge,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Serif,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .width(80.dp)
                        .clip(AbsoluteRoundedCornerShape(12.dp)),
                    thickness = 5.dp,
                    color = Color(0xFF0073E6)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF005BB5),
                        contentColor = Color.Black,
                        disabledContainerColor = Color.White,
                        disabledContentColor = Color.LightGray
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF00336F)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Personal Information",
                            style = MaterialTheme.typography.headlineMedium,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding(5.dp),
                            color = Color.LightGray
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    HorizontalDivider()
                    Text(
                        text = "Name: ${mockUserProfile.name}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Branch: ${mockUserProfile.branch}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Course: ${mockUserProfile.course}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Gender: ${mockUserProfile.gender}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Email: ${mockUserProfile.officialMailId}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Phone: ${mockUserProfile.phoneNumber}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "Section: ${mockUserProfile.section}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Text(
                        text = "SIC: ${mockUserProfile.sic}",
                        modifier = Modifier.padding(12.dp, 4.dp),
                        color = Color.White
                    )
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}
