package com.example.loginroomdatabase

import android.util.Patterns
import java.util.regex.Pattern

object Email {

    fun getOtpFromMessage(data: String): String {
        val pattern = Pattern.compile("(|^)\\d{6}")
        val matcher = pattern.matcher(data)
        return if (matcher.find()) {
            matcher.group(0)!!
        } else {
            ""
        }
    }

    fun isValidEmail(email: String): Boolean {
        return if (email.isEmpty()) {
            false
        } else if (!email.contains("@")) {
            false
        } else if (email.length <= 6) {
            false
        } else Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return if(password.isEmpty()){
            false
        } else password.length > 6
    }
}