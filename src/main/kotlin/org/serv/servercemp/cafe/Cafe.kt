import jakarta.persistence.*
import org.serv.servercemp.user.Product

@Entity(name = "cafe_table")

class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null
    var address: String? = null
    var telephone: String? = null

    @OneToMany(mappedBy = "cafe")
    var products: List<Product> = emptyList()
}