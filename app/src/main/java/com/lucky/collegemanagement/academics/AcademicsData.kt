package com.lucky.collegemanagement.academics

data class Subject(
    val subjectName: String = "",
    val branchSection: String = "",
    val rollNo: Int = 0,
    val faculty: String = "",
    val attendancePercentage: Double = 0.0,
    val courseCoverage: Double = 0.0,
    val courseHandout: String = "",
    val modelQuestion: String = ""
)
