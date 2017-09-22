package com.events.application.configurations

import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration

/**
 * @author SutulovAI
 *
 * Configuration of Spring Security
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class SecurityConfig : GlobalMethodSecurityConfiguration() {

    @Autowired
    private val permissionEvaluator: DomainAwarePermissionEvaluator? = null

    @Autowired
    private val applicationContext: ApplicationContext? = null

    override fun createExpressionHandler(): MethodSecurityExpressionHandler {

        val expressionHandler = DefaultMethodSecurityExpressionHandler()
        expressionHandler.setPermissionEvaluator(permissionEvaluator)
        expressionHandler.setApplicationContext(applicationContext!!)

        return expressionHandler
    }
}