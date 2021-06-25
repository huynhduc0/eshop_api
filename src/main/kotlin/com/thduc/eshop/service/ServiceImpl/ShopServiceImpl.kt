package com.thduc.eshop.service.ServiceImpl

import com.thduc.eshop.entity.User
import com.thduc.eshop.repository.ShopRepository

interface ShopServiceImpl {
    abstract fun summary(currentUser: User?):List<ShopRepository.Summary>
}