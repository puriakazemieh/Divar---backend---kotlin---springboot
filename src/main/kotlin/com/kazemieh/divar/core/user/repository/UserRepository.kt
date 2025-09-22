package com.kazemieh.divar.core.user.repository

import com.kazemieh.divar.core.user.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {

}