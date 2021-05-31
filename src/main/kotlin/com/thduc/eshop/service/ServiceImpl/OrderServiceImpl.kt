package com.thduc.eshop.service.ServiceImpl

import com.thduc.eshop.entity.Orders
import com.thduc.eshop.entity.User

interface OrderServiceImpl {
    abstract fun changeStatus(currentUser: User, id: Long, orders: Orders): Orders
    abstract fun getById(id: Long): Orders
}