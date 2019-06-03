package pl.coderslab.app.orders;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.List;

public interface OrderRepo extends JpaRepository <Order,Long> {

    @Query(value = "select * from orders where przedstawicielMedyczny_id =?1", nativeQuery = true)
    List<Order> ordersPM(Long jeden);
}
