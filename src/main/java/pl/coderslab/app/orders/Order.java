package pl.coderslab.app.orders;

import pl.coderslab.app.pm.PrzedstawicielMedyczny;
import pl.coderslab.app.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//toDo zrobić status zamowienia zeby rkp zatwierdzal jeszcze zlozone zamowienie
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.MERGE)
    private PrzedstawicielMedyczny przedstawicielMedyczny;
    private LocalDateTime created;
    @Column(scale=2, precision=6)
    private BigDecimal totalAmount;
    private String status;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
        setStatus("New order");
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PrzedstawicielMedyczny getPrzedstawicielMedyczny() {
        return przedstawicielMedyczny;
    }

    public void setPrzedstawicielMedyczny(PrzedstawicielMedyczny przedstawicielMedyczny) {
        this.przedstawicielMedyczny = przedstawicielMedyczny;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
