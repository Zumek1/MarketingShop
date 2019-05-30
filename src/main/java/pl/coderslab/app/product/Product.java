package pl.coderslab.app.product;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String medicalLine;
    @NotBlank
    private int magQuantity;
    @NotBlank
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
