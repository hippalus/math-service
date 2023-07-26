package com.github.hippalus.mathservice.api.model

import com.github.hippalus.mathservice.domain.model.CalculationResult

data class SmallestNumberCalculationResponse(
    val smallestNumber: Long,
    val upperNumber: Long,
    val timeTaken: Long
) {

    companion object {

        fun from(calculationResult: CalculationResult) = SmallestNumberCalculationResponse(
            smallestNumber = calculationResult.smallestNumber,
            upperNumber = calculationResult.upperNumber,
            timeTaken = calculationResult.timeTaken
        )

    }
}