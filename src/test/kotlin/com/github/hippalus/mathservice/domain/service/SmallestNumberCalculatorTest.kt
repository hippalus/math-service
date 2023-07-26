package com.github.hippalus.mathservice.domain.service


import com.github.hippalus.mathservice.domain.model.CalculationResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit


class SmallestNumberCalculatorTest {

    private val smallestNumberCalculator: SmallestNumberCalculator = SmallestNumberCalculator()

    @Test
    fun testCalculateWithMetrics() {
        val upperNumber = 10L
        val startTimeMillis = System.currentTimeMillis()
        val endTimeMillis = startTimeMillis + TimeUnit.SECONDS.toMillis(1) // Simulate a calculation that takes 1 second
        val smallestNumber = 2520L
        val expectedCalculationResult = CalculationResult(smallestNumber, upperNumber, endTimeMillis - startTimeMillis)
        val calculationResult = smallestNumberCalculator.calculateWithMetrics(upperNumber)
        assertEquals(expectedCalculationResult.smallestNumber, calculationResult.smallestNumber)
        assertEquals(expectedCalculationResult.upperNumber, calculationResult.upperNumber)
    }

    @Test
    fun testCalculate() {
        val upperNumber = 10L
        val expectedSmallestNumber = 2520L
        val smallestNumber = smallestNumberCalculator.calculate(upperNumber)
        assertEquals(expectedSmallestNumber, smallestNumber)
    }

    @Test
    fun testCalculate_25() {
        val upperNumber = 25L
        val expectedSmallestNumber = 26771144400L
        val smallestNumber = smallestNumberCalculator.calculate(upperNumber)
        assertEquals(expectedSmallestNumber, smallestNumber)
    }
}

