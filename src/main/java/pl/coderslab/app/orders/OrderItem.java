package pl.coderslab.app.orders;

import pl.coderslab.app.product.Product;
import java.math.BigDecimal;

public class OrderItem {

    private int quantity;
    private Product product;
    private BigDecimal amount;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
