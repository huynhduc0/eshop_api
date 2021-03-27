package com.thduc.eshop.entity

import com.thduc.eshop.constant.Status
import org.neo4j.ogm.annotation.NodeEntity
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@NodeEntity
class Address (
    @Id @GeneratedValue var id:Long?,
    var address: String?,
    var lat: Float? = null,
    var lon: Float? = null,
    var status: Status?

){
}