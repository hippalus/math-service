package com.github.hippalus.mathservice.infra.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter

@Configuration
class JacksonConfig {

    @Bean
    fun jsonConverter(): MappingJackson2HttpMessageConverter? {
        return MappingJackson2HttpMessageConverter()
    }

    @Bean
    fun xmlConverter(): MappingJackson2XmlHttpMessageConverter? {
        return MappingJackson2XmlHttpMessageConverter()
    }
}