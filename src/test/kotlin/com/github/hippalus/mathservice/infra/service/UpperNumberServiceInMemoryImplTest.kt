package com.github.hippalus.mathservice.infra.service


import com.github.hippalus.mathservice.domain.service.UpperNumberService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cache.CacheManager
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

private const val KEY_CURRENT_UPPER_NUMBER = "current-upper-number"
private const val CACHE_UPPER_NUMBER = "upper-number"

@SpringJUnitConfig
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UpperNumberServiceInMemoryImplIntegrationTest {

    @Autowired
    private lateinit var upperNumberService: UpperNumberService

    @Autowired
    private lateinit var cacheManager: CacheManager

    @BeforeEach
    fun setUp() {
        // Clear the cache before each test
        val cache = cacheManager.getCache(CACHE_UPPER_NUMBER)
        cache?.clear()
    }

    @Test
    fun `test setUpperNumber and getUpperNumber`() {
        val upperNumber = 25L

        upperNumberService.setUpperNumber(upperNumber)

        val result = upperNumberService.getUpperNumber()
        assertEquals(upperNumber, result)
    }

    @Test
    fun `test getUpperNumber when not set`() {
        val result = upperNumberService.getUpperNumber()

        assertEquals(0L, result)
    }
}
