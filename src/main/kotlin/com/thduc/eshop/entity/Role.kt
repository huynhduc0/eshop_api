package com.thduc.eshop.entity

import org.hibernate.validator.constraints.UniqueElements
import org.neo4j.ogm.annotation.NodeEntity
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@NodeEntity
class Role(
    @Id @GeneratedValue
    var id: Long? = null,
//    @UniqueElements
    var roleName: String? = null
) {
}