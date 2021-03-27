package com.thduc.eshop.entity

import com.thduc.eshop.constant.Status
import org.neo4j.ogm.annotation.NodeEntity
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.*

@NodeEntity
class Shop(
    @Id @GeneratedValue var id: Long? = null,
    @Relationship("HAS_ADDRESS", direction = Relationship.Direction.OUTGOING)
    var mainAddress: Address? = null,
    @CreatedBy var createdBy: User,
    @CreatedDate var created: Date? = Date(),
    @LastModifiedDate var updated: Date = Date(),
    var status: Status?= Status.ACTIVATE
) {

}