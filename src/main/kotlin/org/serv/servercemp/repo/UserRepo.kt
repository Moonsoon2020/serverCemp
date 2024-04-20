import org.serv.servercemp.User
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository : CrudRepository<User, Integer> {
}