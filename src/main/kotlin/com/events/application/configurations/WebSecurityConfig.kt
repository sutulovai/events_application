package com.events.application.configurations

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.savedrequest.NullRequestCache
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired


/**
 * @author SutulovAI
 *
 * Web security configuration
 */

@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
        http!!.authorizeRequests()
                .anyRequest().authenticated()
                .and().requestCache().requestCache(NullRequestCache())
                .and().httpBasic()
                .and().csrf().disable()
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").authorities("ROLE_USER")
                .and()
                .withUser("admin").password("password").authorities("ROLE_USER", "ROLE_ADMIN")
    }
}