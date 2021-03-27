package com.thduc.eshop.entity

import com.thduc.eshop.constant.Status
import org.neo4j.ogm.annotation.NodeEntity
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@NodeEntity
class Media(
    @Id @GeneratedValue var id: Long? = null,
    val mediaPath: String? = null,
    val mediaType: String? = null,
    val authorId: Long? = null,
    var status: Status?= Status.ACTIVATE
//    @CreatedBy val createdBy: User
) {

}