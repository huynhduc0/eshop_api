package com.thduc.eshop.controller

import com.thduc.eshop.annotation.ActiveUser
import com.thduc.eshop.entity.Product
import com.thduc.eshop.request.UserPrincipal
import com.thduc.eshop.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("products")
class UserProductController(
    @Autowired val productService:ProductService,
) {
    @GetMapping
    fun getMyProduct(@ActiveUser userPrincipal: UserPrincipal,
                     @RequestParam(value = "page",defaultValue = "0")  page: Int,
                     @RequestParam(value = "size", defaultValue = "10")  size: Int,
                     @RequestParam(value = "sortBy", defaultValue = "id")  sortBy: String,
                     @RequestParam(value = "sortOrder", defaultValue = "")  sortOrder: String
    ): Page<Product> {
        return if (sortOrder == "desc")
            productService.loadProductByUser(userPrincipal.currentUser!!, PageRequest.of(page, size, Sort.by(sortBy).descending()))
        else productService.loadProductByUser(userPrincipal.getUser()!!, PageRequest.of(page, size, Sort.by(sortBy)))
    }
}