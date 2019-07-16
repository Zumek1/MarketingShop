package pl.coderslab.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.orders.Order;
import pl.coderslab.app.orders.OrderItem;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAllSQL();
    }
    public Product findById(Long id){return productRepo.findOne(id);}
    public void update (Product product){
        productRepo.save(product);
    }
    public void setMagCancelOrder (Order order){
        List<OrderItem> orderItems = order.getOrderItems();
        for(int i=0;i<orderItems.size();i++){
            Product product = productRepo.findOne(orderItems.get(i).getProduct().getId());
            product.setMagQuantity(product.getMagQuantity()+orderItems.get(i).getQuantity());
            productRepo.save(product);
        }

    }
}
