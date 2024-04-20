package org.serv.servercemp.user
import org.springframework.data.repository.CrudRepository;

interface ProductRepository : CrudRepository<Product, Int> {

}