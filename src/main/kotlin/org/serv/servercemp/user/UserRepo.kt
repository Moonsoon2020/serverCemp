package org.serv.servercemp.user
import org.springframework.data.repository.CrudRepository;

interface PersonRepository : CrudRepository<Person, Int> {

}