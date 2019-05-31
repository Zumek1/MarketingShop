package pl.coderslab.app.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderItemRepo orderItemRepo;

public List<Order> findAll(){
    return orderRepo.findAll();

}

public void saveOrder(Order order){
    orderRepo.save(order);
}
public void SaveItem(OrderItem orderItem){orderItemRepo.save(orderItem);}

}
