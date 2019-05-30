package pl.coderslab.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
