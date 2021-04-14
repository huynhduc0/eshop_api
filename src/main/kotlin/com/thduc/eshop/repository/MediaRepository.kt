package com.thduc.eshop.repository

import com.thduc.eshop.entity.Media
import com.thduc.eshop.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

import org.springframework.stereotype.Repository


@Repository
interface MediaRepository: PagingAndSortingRepository<Media, Long> {
    fun findByCreatedBy(user: User,pageable: Pageable):Page<Media>
}