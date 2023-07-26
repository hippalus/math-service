package com.github.hippalus.mathservice.api.controller

import com.github.hippalus.mathservice.api.model.SmallestNumberCalculationResponse
import com.github.hippalus.mathservice.domain.service.MathService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/smallest-numbers")
class SmallestNumberController(
    private val mathService: MathService
) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun calculate(): ResponseEntity<SmallestNumberCalculationResponse> {
        val calculationResult = mathService.calculateSmallestNumber()
        return ResponseEntity.ok(SmallestNumberCalculationResponse.from(calculationResult))
    }


}
