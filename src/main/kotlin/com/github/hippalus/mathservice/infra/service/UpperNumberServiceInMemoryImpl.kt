package com.github.hippalus.mathservice.infra.service

import com.github.hippalus.mathservice.domain.service.UpperNumberService
import org.springframework.cache.Cache
import org.springframework.cache.CacheManager
import org.springframework.stereotype.Service

private const val KEY_CURRENT_UPPER_NUMBER = "current-upper-number"
private const val CACHE_UPPER_NUMBER = "upper-number"

@Service
class UpperNumberServiceInMemoryImpl(
    private val cacheManager: CacheManager
) : UpperNumberService {

    override fun setUpperNumber(upperNumber: Long) {
        val cache: Cache = checkNotNull(cacheManager.getCache(CACHE_UPPER_NUMBER))
        cache.put(KEY_CURRENT_UPPER_NUMBER, upperNumber)
    }

    override fun getUpperNumber(): Long {
        val cache: Cache = checkNotNull(cacheManager.getCache(CACHE_UPPER_NUMBER))
        return (cache[KEY_CURRENT_UPPER_NUMBER]?.get() ?: 0L) as Long
    }


}