package com.thduc.eshop.entity

import com.thduc.eshop.relationship.Order
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.*

@Node
class User(
    @Id @GeneratedValue var id:Long?,
    var username: String,
    var fullname: String,
    var password: String?,
    var socialId: String?,
    var phoneNumber: String?,
    var avatar: Media?,
    @Relationship(type = "HAS_ROLE", direction = Relationship.Direction.OUTGOING) var addresses: Set<Address>?,
    @Relationship(type = "HAS_ROLE", direction = Relationship.Direction.OUTGOING) var roles: Set<Role>?,
    @CreatedDate var created: Date = Date(),
    @Relationship(type = "LIKE", direction = Relationship.Direction.INCOMING) var order: Set<Order>?,
    @LastModifiedDate var updated: Date = Date(),
) {

}