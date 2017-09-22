package com.events.application.controllers

import java.util.Collections.singletonMap
import javax.servlet.http.HttpSession
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*


@RequestMapping("/api/auth")
@RestController
internal class AuthEndpoint {

    @GetMapping
    fun getToken(session: HttpSession): Map<String, Any> {
        return Collections.singletonMap("session", session.id)
    }
}