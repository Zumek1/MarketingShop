package pl.coderslab.app.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.pm.PrzedstawicielMedyczny;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
