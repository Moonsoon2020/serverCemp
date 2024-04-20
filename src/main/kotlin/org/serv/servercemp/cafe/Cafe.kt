package org.serv.servercemp.cafe

import jakarta.persistence.*
import org.serv.servercemp.user.Product

@Entity
class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null
    var address: String? = null
    var name: String? = null
    var telephone: String? = null
    var products: String = ""

}