package org.serv.servercemp.cafe

import org.serv.servercemp.user.CafeRepository
import org.serv.servercemp.user.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CafeController {
    @Autowired
    private lateinit var cafeRepository: CafeRepository

    @Autowired
    private lateinit var personRepository: PersonRepository


    @PostMapping("/addcafe")
    @ResponseBody
    fun addNewCafe(@RequestParam id: Int, @RequestParam name: String, @RequestParam address: String): Map<String, Any> {
        var map = mutableMapOf<String, Any>()
        for (cafe in cafeRepository.findAll()) {
            if (cafe.id == id || cafe.name == name) {
                map["status"] = false
                map["errore"] = "кафе уже существует"
                return map
            }
        }
        val cafe = Cafe()
        cafe.name = name
        cafe.address = address
        cafeRepository.save(cafe)
        if (cafe.id != null) {
            map = set_cafe(id, cafe.id!!)
            map["id"] = cafe.id!!
            return map
        } else {
            map["status"] = false
            map["errore"] = "id errore"
            return map
        }
    }

    @PostMapping("/setcafe")
    @ResponseBody
    fun set_cafe(@RequestParam id: Int, @RequestParam id_cafe: Int): MutableMap<String, Any> {
        val person = personRepository.findById(id)
        if (person.isPresent) {
            val foundPerson = person.get()
            foundPerson.cafe = id_cafe
            personRepository.save(foundPerson)
            val map = mutableMapOf<String, Any>()
            map["status"] = true
            return map
        } else {
            val map = mutableMapOf<String, Any>()
            map["status"] = false
            map["error"] = "User with id $id not found"
            return map
        }
    }

    @GetMapping("/allcafes")
    @ResponseBody
    fun getAllCafes(): Iterable<Cafe> {
        return cafeRepository.findAll()
    }

    @GetMapping("/cafebyid")
    @ResponseBody
    fun getCafeById(@RequestParam id: Int): Cafe? {
        return cafeRepository.findById(id).orElse(null)
    }
}
