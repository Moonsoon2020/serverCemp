package org.serv.servercemp.product

import org.serv.servercemp.user.Product
import org.serv.servercemp.user.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ProductController {
    @Autowired
    private lateinit var productRepository: ProductRepository

    @PostMapping("/newproduct")
    @ResponseBody
    fun addNewProduct(@RequestParam title: String, @RequestParam description: String,
                      @RequestParam image : String, @RequestParam id_cafe: Int): Map<String, Any> {
        val map = mutableMapOf<String, Any>()
        val product = Product()
        product.title = title
        product.description = description
        product.image = image
        product.id_cafe = id_cafe
        productRepository.save(product)
        map["status"] = true
        map["id"] = product.id!!
        return map
    }

    @GetMapping("/allproduct")
    @ResponseBody
    fun getAllproducts(): Iterable<Product> {
        return productRepository.findAll()
    }
    @GetMapping("/productbyid")
    @ResponseBody
    fun getproductByID(@RequestParam id: Int): Product? {
        val product = productRepository.findById(id)
        return product.orElse(null)
    }

    @GetMapping("/productsbyidcafe")
    @ResponseBody
    fun getproductsByID(@RequestParam id_cafe: Int): Iterable<Product>? {
        var iter = mutableListOf<Product>()
        for (item in productRepository.findAll()){
            if(item.id_cafe == id_cafe){
               iter.add(item)
            }
        }
        return iter
    }
}
