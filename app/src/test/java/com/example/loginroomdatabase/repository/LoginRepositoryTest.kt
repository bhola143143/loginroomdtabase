package com.example.loginroomdatabase.repository


import com.example.loginroomdatabase.Email
import com.google.common.truth.Truth.assertThat

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EmailTest {

    @Test
    fun emptyEmail() {
        val result = Email.isValidEmail("")
        assertThat(result).isFalse()
    }

    @Test
    fun invalidEmail() {
        val result = Email.isValidEmail("asdf2")
        assertThat(result).isFalse()
    }





    @Test
    fun emptyPwd() {
        val result = Email.isValidPassword("")
        assertThat(result).isFalse()
    }

    @Test
    fun `invalid Password`() {
        val result = Email.isValidPassword("123456")
        assertThat(result).isFalse()
    }


}