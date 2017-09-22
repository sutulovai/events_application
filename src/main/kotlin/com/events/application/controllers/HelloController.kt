package com.events.application.controllers

import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/")
    fun hello() = "hello"

    @GetMapping("/test")
    @Secured("ROLE_USER")
    fun test() = "hello"
}