package com.github.hippalus.mathservice.infra.service

import com.github.hippalus.mathservice.domain.service.UpperNumberService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class UpperNumberServiceInMemoryImpl : UpperNumberService {

    private var num: Long = 0

    @CacheEvict(value = ["upper-number"], key = "'current-upper-number'")
    override fun setUpperNumber(upperNumber: Long) {
        num = upperNumber
    }

    @Cacheable(value = ["upper-number"], key = "'current-upper-number'")
    override fun getUpperNumber(): Long {
        return num
    }


}