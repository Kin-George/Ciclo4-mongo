package ciclo4.reto2.interfaces;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import ciclo4.reto2.modelo.Order;

public interface interfaceOrder extends MongoRepository<Order, Integer> {
    List<Order> findBySalesManZone(String zone);
    
}
