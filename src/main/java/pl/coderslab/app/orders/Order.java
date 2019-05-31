package pl.coderslab.app.orders;

import pl.coderslab.app.pm.PrzedstawicielMedyczny;

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
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();
    @ManyToOne
    private PrzedstawicielMedyczny przedstawicielMedyczny;
    private LocalDateTime created;
    @Column(scale=2, precision=6)
    private BigDecimal totalAmount;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
