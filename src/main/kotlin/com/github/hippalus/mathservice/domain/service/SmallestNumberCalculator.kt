package com.github.hippalus.mathservice.domain.service

import com.github.hippalus.mathservice.domain.model.CalculationResult
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
@CacheConfig(cacheNames = ["smallest-numbers"])
class SmallestNumberCalculator {

    @Cacheable
    fun calculateWithMetrics(upperNumber: Long): CalculationResult {
        val startTime = System.currentTimeMillis()
        val smallestNumber = calculate(upperNumber)
        val endTime = System.currentTimeMillis()
        val timeTaken = endTime - startTime
        return CalculationResult(smallestNumber, upperNumber, timeTaken)
    }

    fun calculate(upperNumber: Long): Long {
        var smallestNumber: Long = 1
        for (i in 1..upperNumber) {
            smallestNumber = lcm(smallestNumber, i)
        }
        return smallestNumber
    }

    private fun lcm(a: Long, b: Long): Long {
        return a * b / gcd(a, b)
    }

    private fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) {
            a
        } else gcd(b, a % b)
    }

}
