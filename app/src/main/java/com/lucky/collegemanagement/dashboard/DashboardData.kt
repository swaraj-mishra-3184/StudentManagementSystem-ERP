package com.lucky.collegemanagement.dashboard

import androidx.compose.ui.graphics.Color

data class DashboardData(
    val facultyAdvisorName: String = "",
    val facultyAdvisorPhoneNumber: String = "",
    val regdNo: String = "",
    val program: String = "",
    val branch: String = "",
    val section: String = "",
    val timeTableLink: String = "",
    val subjects: String = "",
    val lowAttendance: String = "",
    val highAttendance: String = "",
    val examScheduleToday: String = "",
    val examScheduleTomorrow: String = "",
    val resultInfo: String = "",
    val libraryBooks: String = "",
    val libraryReturnToday: String = "",
    val libraryReturnWeek: String = "",
    val hostelRegistrationDate: String = "",
    val hostelName: String = "",
    val roomNumber: String = "",
    val bedNumber: String = "",
    val duesAmount: String = "",
    val canteenRegistration: String = "",
    val onlineQuizExamInfo: String = "",
    val onlineWrittenExamInfo: String = "",
    val profileName: String = "",
    val profileMobile: String = "",
    val profileEmail: String = "",
    val holidaysYear: String = "",
    val holidaysTotal: String = "",
    val feedbackStart: String = "",
    val feedbackEnd: String = "",
    val courseFeedbackStart: String = "",
    val courseFeedbackEnd: String = "",
    val practiceSchoolInfo: String = "",
    val officialMailEmail: String = "",
    val officialMailPassword: String = ""
) {
    fun getAllData(): List<Triple<String, String, Color>> {
        return listOf(
            Triple("Faculty Advisor", "$facultyAdvisorName\nContact: $facultyAdvisorPhoneNumber", Color(0xFFE57373)),
            Triple("Academics", "Regd no: $regdNo\nProgram: $program\nBranch: $branch\nSection: $section", Color(0xFF64B5F6)),
            Triple("Time Table", timeTableLink, Color(0xFFFFB74D)),
            Triple("Attendance", "Subjects: $subjects\n0 to 79%: $lowAttendance\n80% to 100%: $highAttendance", Color(0xFF9575CD)),
            Triple("Exam Schedule", "Today: $examScheduleToday\nTomorrow: $examScheduleTomorrow", Color(0xFF4DB6AC)),
            Triple("Result", resultInfo, Color(0xFFF06292)),
            Triple("Library", "Books with me: $libraryBooks\nTo be returned today: $libraryReturnToday\nTo be returned this week: $libraryReturnWeek", Color(0xFFFFB74D)),
            Triple("Hostel", "Registered, Since: $hostelRegistrationDate\nHostel: $hostelName\nRoom No: $roomNumber, Bed No: $bedNumber", Color(0xFFD81B60)),
            Triple("Dues", "Total Dues: $duesAmount", Color(0xFF4CAF50)),
            Triple("Canteen", canteenRegistration, Color(0xFFE57373)),
            Triple("Online Quiz Exam", onlineQuizExamInfo, Color(0xFF64B5F6)),
            Triple("Online Written Exam", onlineWrittenExamInfo, Color(0xFF4DB6AC)),
            Triple("Profile", "Name: $profileName\nMobile: $profileMobile\nEmail: $profileEmail", Color(0xFF4CAF50)),
            Triple("Holidays", "Leave Year: $holidaysYear\nTotal Holiday: $holidaysTotal", Color(0xFF9575CD)),
            Triple("Feedback", "START: $feedbackStart\nEND: $feedbackEnd", Color(0xFF9575CD)),
            Triple("Course Feedback", "START: $courseFeedbackStart\nEND: $courseFeedbackEnd", Color(0xFF4DB6AC)),
            Triple("Practice School", practiceSchoolInfo, Color(0xFFD81B60)),
            Triple("Official Mail", "Email Id: $officialMailEmail\nPassword: $officialMailPassword", Color(0xFF64B5F6))
        )
    }
}
