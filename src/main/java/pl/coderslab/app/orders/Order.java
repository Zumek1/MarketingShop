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
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {

        this.orderItems = orderItems;
        for(int i=0;i<orderItems.size();i++){
            orderItems.get(i).setOrder(this);
        }
    }
}
