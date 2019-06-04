package pl.coderslab.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.orders.OrderItem;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }
    public Product findById(Long id){return productRepo.findOne(id);}

    public void updateProductMagQuantity(List<OrderItem> orderItems){
        for(int i=0;i<orderItems.size();i++){
            Product product = findById(orderItems.get(i).getProduct().getId());
            int tempMagQuantity = product.getMagQuantity()-orderItems.get(i).getQuantity();
            product.setMagQuantity(tempMagQuantity);
            productRepo.save(product);
        }
    }
}
