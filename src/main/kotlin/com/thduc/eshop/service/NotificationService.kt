package com.thduc.eshop.service;

import com.thduc.eshop.constant.NotificationType
import com.thduc.eshop.entity.AppNotification
import com.thduc.eshop.entity.Device
import com.thduc.eshop.entity.User
import com.thduc.eshop.exception.DataNotFoundException
import com.thduc.eshop.repository.NotificationRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service;
import java.util.*

@Service
class NotificationService(
        @Autowired val notificationRepository: NotificationRepository,
        @Autowired val fcmPushService:FCMPushService
) {
        fun addNotification(
                to: User?,
                message: String?,
                title:String?,
                notificationType: NotificationType?,
                destinationId: Long,
                image: String?,
        ): AppNotification? {
                val notification = AppNotification(title = title,notificationType = notificationType,image = image,message = message,destinationId = destinationId,toUser = to )
                val notifications: AppNotification = notificationRepository.save(notification)
                fcmPushService.sendPnsToDevice(notifications)
                return notifications
        }

        fun getByUser(currentUser: User, of: PageRequest): Page<AppNotification> {
                return notificationRepository.findAllByToUser(currentUser,of)
        }

        fun seen(id: Long) {
                var noti = notificationRepository.findById(id).orElseThrow { DataNotFoundException("j noti","id",id.toString()) }
                noti.seenDate = Date()
                noti.seen = true
                notificationRepository.save(noti)
        }

}
