package pl.coderslab.app.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepo orderRepo;


public List<Order> findAll(){
    return orderRepo.findAll();
}


public void saveOrder(Order order){
    orderRepo.save(order);
}
public List<Product> getFromOrderItem(List<OrderItem> orderItems){
    List<Product> products = new ArrayList<>();
    for(int i=0;i<orderItems.size();i++){
        products.add(orderItems.get(i).getProduct());
    }
    return products;
}
public List<Order> orders(Long id){
    List<Order> orders = orderRepo.ordersPM(id);
    return orders;
}

public Order orderById(Long id){
    Order order = orderRepo.findOne(id);
    return order;
}


}


