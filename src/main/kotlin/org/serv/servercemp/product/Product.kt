package org.serv.servercemp.user

import jakarta.persistence.*

@Entity
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null
    var image: String? = null // Assuming you store image path
    var title: String? = null
    var description: String? = null
    var id_cafe:Int? = null
}