import org.serv.servercemp.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class MainController {
    @Autowired
    private lateinit var personRepository: PersonRepository


    @RequestMapping("/")
    fun index(): String {
        return "index"
    }

    @GetMapping("/addperson")
    @ResponseBody
    fun addNewUser(@RequestParam name: String): String {
        val person = User()
        person.name = name
        personRepository.save(person)
        return "Person saved!"
    }


    @GetMapping("/allpersons")
    @ResponseBody
    fun getAllUsers(): Iterable<User> {
        return personRepository.findAll()
    }

}
