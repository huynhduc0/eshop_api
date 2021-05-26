package com.thduc.eshop.repository

import com.thduc.eshop.entity.AppNotification
import org.springframework.data.repository.PagingAndSortingRepository


interface NotificationRepository: PagingAndSortingRepository<AppNotification, Long> {
}