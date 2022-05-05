package com.example.espressotest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    private lateinit var  resourceComparer: ResourceComparer

    @Before
    fun setUp() { resourceComparer =  ResourceComparer() }

    @After
    fun tearDown() {
        // close database for instance
    }


    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Espresso test")
        assertThat(result).isTrue()

    }

    @Test
    fun stringResourceDifferentThanGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Testing")
        assertThat(result).isFalse()

    }
}