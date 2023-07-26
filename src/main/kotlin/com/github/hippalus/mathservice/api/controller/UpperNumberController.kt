package com.github.hippalus.mathservice.api.controller

import com.github.hippalus.mathservice.api.model.SetUpperNumberRequest
import com.github.hippalus.mathservice.domain.service.UpperNumberService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/upper-number")
class UpperNumberController(
    private val upperNumberService: UpperNumberService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun setUpperNumber(@RequestBody request: SetUpperNumberRequest) =
        upperNumberService.setUpperNumber(request.upperNumber)
}
