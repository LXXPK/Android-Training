package com.example.tiptime
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat
class CalculateTipTest {

    @Test
    fun calculateTip_15PercentWithRoundUp() {
        // Given
        val amount = 12.0
        val tipPercent = 15.0
        // 15% of 12 = 1.8 → rounds up to 2.0

        // When
        val actualTip = calculateTip(
            amount = amount,
            tipPercent = tipPercent,
            roundUp = true
        )

        // Then
        val expectedTip = NumberFormat
            .getCurrencyInstance()
            .format(2.0)

        assertEquals(expectedTip, actualTip)
    }
}