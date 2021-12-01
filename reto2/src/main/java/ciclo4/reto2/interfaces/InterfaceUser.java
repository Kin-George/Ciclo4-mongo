package ciclo4.reto2.interfaces;

import ciclo4.reto2.modelo.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceUser extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
