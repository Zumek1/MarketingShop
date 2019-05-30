package pl.coderslab.app.orders;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.app.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "orderItem")
// toDo zobacz czy tu jest potzrebne pole data utworzenia i metoda prePresist
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    private double amount;

    //todo zobaczyc czy nie dac to lacznej wartosci dla tego jednego produktu ilosc*cena
    //todo czy nie lepiej jak ta klasa nie bedzie encja?

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
