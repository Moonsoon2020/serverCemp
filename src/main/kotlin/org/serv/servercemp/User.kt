package org.serv.servercemp

import jakarta.persistence.*
import java.util.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id_person: Int? = null

    var name: String? = null
//
//    @OneToMany(mappedBy = "owner")
//    var phones: List<PhoneNumber>? = null

}
