package com.github.hippalus.mathservice.api.controller


import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hippalus.mathservice.api.model.SmallestNumberCalculationResponse
import com.github.hippalus.mathservice.domain.model.CalculationResult
import com.github.hippalus.mathservice.domain.service.MathService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@ExtendWith(MockitoExtension::class)
@WebMvcTest(SmallestNumberController::class)
class SmallestNumberControllerTest {

    @MockBean
    private lateinit var mathService: MathService

    private val objectMapper = ObjectMapper()

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `test calculate endpoint`() {
        val calculationResult = CalculationResult(2520L, 10L, 500L)
        val expectedResponse = SmallestNumberCalculationResponse.from(calculationResult)
        val expectedResponseJson = objectMapper.writeValueAsString(expectedResponse)

        `when`(mathService.calculateSmallestNumber()).thenReturn(calculationResult)

        mockMvc.perform(
            get("/api/smallest-numbers")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(expectedResponseJson))
    }
}
