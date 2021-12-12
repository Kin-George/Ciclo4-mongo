package ciclo4.reto2.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciclo4.reto2.modelo.Order;
import ciclo4.reto2.repositorio.OrderRepositorio;

@Service
public class OrderService {
    @Autowired
    private OrderRepositorio orderRepository;

    public List<Order> getAll(){
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id){
        return orderRepository.getOrder(id);
    }

    public Order create(Order order){
        if (order.getId() == null){
            return order;
        }else{
            return orderRepository.create(order);
        }
    }

    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());

            if (!orderDb.isEmpty()){
                
                if (order.getId() != null){
                    orderDb.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null){
                    orderDb.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getSalesMan() != null){
                    orderDb.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null){
                    orderDb.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null){
                    orderDb.get().setQuantities(order.getQuantities());
                }

                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int orderId){
        Boolean aBoolean = getOrder(orderId).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }
    
}
