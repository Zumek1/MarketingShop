package pl.coderslab.app.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.pm.PrzedstawicielMedyczny;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "select * from products Order by name", nativeQuery = true)
    List<Product> findAllSQL();
}
