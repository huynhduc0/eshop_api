package com.thduc.eshop.repository

import com.thduc.eshop.constant.StatusType
import com.thduc.eshop.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: PagingAndSortingRepository<Product, Long> {
    fun findAllByStatus(statusType: StatusType,pageable: Pageable): Page<Product>
}