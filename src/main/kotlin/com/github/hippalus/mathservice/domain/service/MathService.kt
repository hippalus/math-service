package com.github.hippalus.mathservice.domain.service

import com.github.hippalus.mathservice.domain.model.CalculationResult
import org.springframework.stereotype.Service

@Service
class MathService(
    private val upperNumberService: UpperNumberService,
    private val smallestNumberCalculator: SmallestNumberCalculator
) {

    fun calculateSmallestNumber(): CalculationResult {
        val upperNumber = upperNumberService.getUpperNumber()
        return smallestNumberCalculator.calculateWithMetrics(upperNumber)
    }
}