package pl.coderslab.app.cart;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.orders.OrderItem;

import java.util.List;

@Service
@Transactional
public class CartItemService {
    public int isExisting(Long id, List<OrderItem> orderItems){
        for(int i = 0; i<orderItems.size();i++){
            if(orderItems.get(i).getProduct().getId()==id){
                return i;
            }
        }
        return -1;
    }


}
