package com.events.application.repositories

import com.events.application.entities.UsersEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component

@Component
interface UsersRepository : CrudRepository<UsersEntity, Int>