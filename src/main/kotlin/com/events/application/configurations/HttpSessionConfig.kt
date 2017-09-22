package com.events.application.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.session.MapSessionRepository
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession
import org.springframework.session.web.http.HeaderHttpSessionStrategy

/**
 * @author SutulovAI
 *
 * Configuration of HTTP sessions
 */

@Configuration
@EnableSpringHttpSession
class HttpSessionConfig {

    @Bean
    fun inMemorySessionFactory() = MapSessionRepository()

    @Bean
    fun httpSessionStrategy() = HeaderHttpSessionStrategy()
}