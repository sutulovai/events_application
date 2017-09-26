package com.events.application.controllers

import com.events.application.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Autowired
    private lateinit var usersRepository: UsersRepository

    @GetMapping("/")
    fun hello() = "hello"

    @GetMapping("/test")
    @Secured("ROLE_USER")
    fun test() = "hello"

    @GetMapping("/testdb")
    fun testDb() = usersRepository.findAll()

}