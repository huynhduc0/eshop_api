package com.thduc.eshop.repository

import com.thduc.eshop.entity.AppNotification
import com.thduc.eshop.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository


interface NotificationRepository: PagingAndSortingRepository<AppNotification, Long> {
    fun findAllByToUser(user: User,pageable: Pageable):Page<AppNotification>
}