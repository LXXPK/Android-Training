package com.example.tiptime

import org.junit.Test
import org.junit.Assert.assertEquals
import java.text.NumberFormat

class ExampleUnitTest {

    @Test
    fun calculateTip_20PercentNoRoundUp() {
        // Given
        val amount = 10.0
        val tipPercent = 20.0

        // When
        val actualTip = calculateTip(
            amount = amount,
            tipPercent = tipPercent,
            roundUp = false
        )

        // Then
        val expectedTip = NumberFormat
            .getCurrencyInstance()
            .format(2.0)

        assertEquals(expectedTip, actualTip)
    }
}
