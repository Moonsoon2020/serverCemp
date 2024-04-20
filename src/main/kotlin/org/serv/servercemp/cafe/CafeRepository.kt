package org.serv.servercemp.user
import org.serv.servercemp.cafe.Cafe
import org.springframework.data.repository.CrudRepository;

interface CafeRepository : CrudRepository<Cafe, Int> {

}