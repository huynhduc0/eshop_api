package com.thduc.eshop.repository

import com.thduc.eshop.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

import org.springframework.stereotype.Repository


@Repository
interface UserRepository: PagingAndSortingRepository<User, Long> {
    fun findByUsername(username:String): User?
    fun findTopBySocialId(socialId:String): User?
    fun findAllByIdNot(id:Long,pageable: Pageable): Page<User>
}