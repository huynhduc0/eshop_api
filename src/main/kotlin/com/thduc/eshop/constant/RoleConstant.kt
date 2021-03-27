package com.thduc.eshop.constant

import org.springframework.stereotype.Component

@Component
object RoleConstant {
    const val ROLE_ADMIN :String = "ROLE_ADMIN"
    const val ROLE_MERCHANT :String = "ROLE_MERCHANT"
    const val ROLE_USER :String = "ROLE_USER"
}