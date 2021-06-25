package com.thduc.eshop.controller.merchant

import com.thduc.eshop.annotation.ActiveUser
import com.thduc.eshop.entity.Orders
import com.thduc.eshop.request.UserPrincipal
import com.thduc.eshop.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional

@RequestMapping("merchant/orders")
@RestController
class MerchantOrderController(
    @Autowired val orderService: OrderService
) {
    @GetMapping
    @Transactional
    fun getAllOrder(
        @ActiveUser userPrincipal: UserPrincipal,
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "sortBy", defaultValue = "id") sortBy: String,
        @RequestParam(value = "sortOrder", defaultValue = "") sortOrder: String
    ): Page<Orders> {
        return if (sortOrder == "desc")
            orderService.getMerchantOder(
                userPrincipal.currentUser!!,
                PageRequest.of(page, size, Sort.by(sortBy).descending())
            )
        else orderService.getMerchantOder(userPrincipal.currentUser!!, PageRequest.of(page, size, Sort.by(sortBy)))
    }

    @PutMapping("{id}")
    fun updateStatus(
        @ActiveUser userPrincipal: UserPrincipal,
        @RequestBody orders: Orders,
        @PathVariable id: Long
    ): Orders {
        return orderService.changeStatus(userPrincipal.currentUser!!, id, orders)
    }
}