package com.thduc.eshop.repository

import com.thduc.eshop.entity.Shop
import com.thduc.eshop.entity.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository: PagingAndSortingRepository<Shop, String> {
    fun findTopByUser(user:User):Shop
    @Query(
        "SELECT user.id,user.fullname,user.avatar, sum(fee) as fee, count(orders.id) as times\n" +
                "FROM orders JOIN shop on orders.shop_id = shop.id JOIN `user` on user.id = shop.user_id\n" +
                "WHERE MONTH(orders.created) = MONTH(CURRENT_DATE())\n and user.id = ?1",
        nativeQuery = true
    )
    fun getSummary(userId:Long):List<Summary>
    @Query(
        "SELECT user.id,user.fullname,user.avatar, sum(fee) as fee, count(orders.id) as times\n" +
                "FROM orders JOIN shop on orders.shop_id = shop.id JOIN `user` on user.id = shop.user_id\n" +
                "WHERE MONTH(orders.created) = MONTH(CURRENT_DATE())\n" +
                "GROUP BY user.id",
        nativeQuery = true
    )
    fun getSummary():List<Summary>
    interface Summary{
        val id:Long?
        val fullname: String?
        val avatar: String?
        val fee: Long?
        val times: Long?
    }
}