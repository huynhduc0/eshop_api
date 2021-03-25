package com.thduc.eshop.entity

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
class Category(
    @Id @GeneratedValue var id: Long?,
    var name: String?,
    @Relationship("HAS_IMAGE",direction = Relationship.Direction.OUTGOING) var image: Media?

) {


}