package com.thduc.eshop.service.ServiceImpl

import com.thduc.eshop.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface UserServiceImpl {
    abstract fun getAllUser(currentUser: User, of: PageRequest): Page<User>

}