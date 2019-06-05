package pl.coderslab.app.product;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.app.orders.Order;
import pl.coderslab.app.orders.OrderItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String medicalLine;

    private int magQuantity;

    private double price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedicalLine() {
        return medicalLine;
    }

    public void setMedicalLine(String medicalLine) {
        this.medicalLine = medicalLine;
    }

    public int getMagQuantity() {
        return magQuantity;
    }

    public void setMagQuantity(int magQuantity) {
        this.magQuantity = magQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
