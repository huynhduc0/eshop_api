package com.thduc.eshop.relationship

import com.thduc.eshop.entity.Product
import com.thduc.eshop.entity.User
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.RelationshipProperties
import org.springframework.data.neo4j.core.schema.TargetNode
import java.util.*

@RelationshipProperties()
class Order(
    @Id
    @GeneratedValue
    var id: Long?,
    @TargetNode
    val product: Product,
    val unitPrice: Long?,
    val quantity: Int?,
    @CreatedBy var user: User,
    @CreatedDate
    var created: Date = Date(),
    @LastModifiedDate
    var updated: Date = Date(),
) {
}