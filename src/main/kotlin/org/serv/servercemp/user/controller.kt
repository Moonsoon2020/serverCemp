package org.serv.servercemp.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PersonController {
    @Autowired
    private lateinit var personRepository: PersonRepository


    @RequestMapping("/")
    @ResponseBody
    fun index(): String {
        val map = mutableMapOf<String, Any>()
        map["status"] = true
        return map.toString()
    }

    @PostMapping("/addperson")
    @ResponseBody
    fun addNewPerson(@RequestParam login: String, @RequestParam password: String, @RequestParam status : Boolean): Map<String, Any> {
        val person = Person()
        person.login = login
        person.password = password
        person.status = status
        personRepository.save(person)
        val map = mutableMapOf<String, Any>()
        map["status"] = true
        return map
    }


    @PostMapping("/setcafe")
    @ResponseBody
    fun set_cafe(@RequestParam id: Int, @RequestParam id_cafe: Int): Map<String, Any> {
        val person = personRepository.findById(id)
        if (person.isPresent) {
            val foundPerson = person.get()
//            foundPerson.id_cafe = id_cafe
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

    @GetMapping("/allpersons")
    @ResponseBody
    fun getAllPersons(): Iterable<Person> {
        return personRepository.findAll()
    }
    @GetMapping("/personbyid")
    @ResponseBody
    fun getPersonByID(@RequestParam id: Int): Person? {
        val person = personRepository.findById(id)
        return person.orElse(null)
    }


}
