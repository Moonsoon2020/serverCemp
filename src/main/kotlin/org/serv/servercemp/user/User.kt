package org.serv.servercemp.user

import jakarta.persistence.*;
import jakarta.persistence.Id

@Entity
class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id_person: Int? = null
    var login: String? = null
    var password: String? = null
    var status: Boolean? = null

    var cafe: Int? = null
}