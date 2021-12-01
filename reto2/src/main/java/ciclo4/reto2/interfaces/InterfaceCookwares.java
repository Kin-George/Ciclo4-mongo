package ciclo4.reto2.interfaces;

import ciclo4.reto2.modelo.Cookwares;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface InterfaceCookwares extends MongoRepository<Cookwares, String> {
    
}
