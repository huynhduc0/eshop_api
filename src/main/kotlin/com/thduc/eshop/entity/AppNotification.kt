package com.thduc.eshop.entity

import com.thduc.eshop.constant.NotificationType
import java.util.*
import javax.persistence.*

@Entity
data class AppNotification(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String?,
    var message:String?,
    var seenDate: Date?=null,
    var seen: Boolean = false,
    var notificationType: NotificationType?,
    var image:String? = null,
    @OneToOne var toUser: User?,
) {
    constructor(): this(null,null,null,null,false,null,null,null)
}