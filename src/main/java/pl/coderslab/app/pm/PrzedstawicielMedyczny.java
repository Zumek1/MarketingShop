package pl.coderslab.app.pm;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.app.orders.Order;
import pl.coderslab.app.rkp.Regionalny;
import pl.coderslab.app.rkp.Regionalny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pm")
public class PrzedstawicielMedyczny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String addres;

    @NotBlank
    private String medicalLine;

    @NotBlank
    private String region;

    @NotBlank
    @Column(scale=2, precision=6)
    private BigDecimal budzet;

    @ManyToOne
    private Regionalny regionalny;

    @OneToMany(mappedBy = "przedstawicielMedyczny",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getMedicalLine() {
        return medicalLine;
    }

    public void setMedicalLine(String medicalLine) {
        this.medicalLine = medicalLine;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getBudzet() {
        return budzet;
    }

    public void setBudzet(BigDecimal budzet) {
        this.budzet = budzet;
    }

    public Regionalny getRegionalny() {
        return regionalny;
    }

    public void setRegionalny(Regionalny regionalny) {
        this.regionalny = regionalny;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
