package com.github.hippalus.mathservice.domain.service


import com.github.hippalus.mathservice.domain.model.CalculationResult
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MathServiceTest {

    @Mock
    private lateinit var upperNumberService: UpperNumberService

    @Mock
    private lateinit var smallestNumberCalculator: SmallestNumberCalculator

    @InjectMocks
    private lateinit var mathService: MathService

    @Test
    fun `test calculateSmallestNumber`() {
        val upperNumber = 10L
        val calculationResult = CalculationResult(2520L, upperNumber, 500L)

        `when`(upperNumberService.getUpperNumber()).thenReturn(upperNumber)
        `when`(smallestNumberCalculator.calculateWithMetrics(upperNumber)).thenReturn(calculationResult)

        val result = mathService.calculateSmallestNumber()

        assertEquals(calculationResult, result)
    }
}
