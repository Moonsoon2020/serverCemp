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

        val map = mutableMapOf<String, Any>()
        for (i in personRepository.findAll()){
            if (i.login == login){
                map["status"] = false
                map["error"] = "Полльзователь с таким логиином существует"
                return map
            }
        }
        val person = Person()
        person.login = login
        person.password = password
        person.status = status
        personRepository.save(person)
        map["status"] = true
        map["id"] = person.id_person!!
        return map
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
