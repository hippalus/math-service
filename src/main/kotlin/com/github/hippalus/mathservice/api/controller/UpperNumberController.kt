package com.github.hippalus.mathservice.api.controller

import com.github.hippalus.mathservice.api.model.SetUpperNumberRequest
import com.github.hippalus.mathservice.domain.service.UpperNumberService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/upper-numbers")
class UpperNumberController(
    private val upperNumberService: UpperNumberService
) {

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
    )
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun setUpperNumber(@RequestBody request: SetUpperNumberRequest) =
        upperNumberService.setUpperNumber(request.upperNumber)
}
