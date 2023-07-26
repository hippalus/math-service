package com.github.hippalus.mathservice.api.controller


import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hippalus.mathservice.api.model.SetUpperNumberRequest
import com.github.hippalus.mathservice.domain.service.UpperNumberService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(MockitoExtension::class)
@WebMvcTest(UpperNumberController::class)
class UpperNumberControllerTest {

    @MockBean
    private lateinit var upperNumberService: UpperNumberService

    private val objectMapper = ObjectMapper()

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `test setUpperNumber endpoint`() {
        val request = SetUpperNumberRequest(25L)
        val requestBody = objectMapper.writeValueAsString(request)

        mockMvc.perform(
            post("/api/upper-numbers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        )
            .andExpect(status().isAccepted)

        verify(upperNumberService).setUpperNumber(request.upperNumber)
    }
}
