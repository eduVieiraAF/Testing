package com.example.espressotest

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty userName returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid userName and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Eduardo",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `userName already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "John",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Eduardo",
            "123456",
            "abcdefg"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Eduardo",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digit password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Eduardo",
            "abcdefg5",
            "abcdefg5"
        )
        assertThat(result).isFalse()
    }
}