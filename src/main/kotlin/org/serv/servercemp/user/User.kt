package org.serv.servercemp.user

import Cafe
import jakarta.persistence.*;
import jakarta.persistence.Id

@Entity
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    var image: String? = null // Assuming you store image path
    var title: String? = null
    var description: String? = null

    @ManyToOne
    var cafe: Cafe? = null
}