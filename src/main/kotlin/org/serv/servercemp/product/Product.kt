package org.serv.servercemp.user

import Cafe
import jakarta.persistence.*

@Entity(name = "person_table")
class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id_person: Int? = null

    var login: String? = null
    var password: String? = null
    var status: Boolean? = null

    @ManyToOne
    var cafe: Cafe? = null
}