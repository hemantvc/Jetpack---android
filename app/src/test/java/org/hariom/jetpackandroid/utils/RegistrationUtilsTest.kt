package org.hariom.jetpackandroid.utils

import org.junit.Assert.*
import org.junit.Test
import com.google.common.truth.Truth.assertThat

/**
 * https://youtu.be/W0ag98EDhGc?list=PLQkwcJG4YTCSYJ13G4kVIJ10X5zisB2Lq
 */
class RegistrationUtilsTest {

    @Test
    fun `empty username return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "",
            "123",
            "123")

        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password return true`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Sid",
            "Hariom123",
            "Hariom123")

        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Hariom",
            "123",
            "123")

        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirm password return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Hariom",
            "123",
            "124")

        assertThat(result).isFalse()
    }

    @Test
    fun `empty password return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Hariom",
            "",
            "")

        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digit password  return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Hariom",
            "Hariom1",
            "Hariom1")

        assertThat(result).isFalse()
    }
}