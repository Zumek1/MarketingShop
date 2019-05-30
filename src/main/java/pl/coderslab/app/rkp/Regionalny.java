package pl.coderslab.app.rkp;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.app.pm.PrzedstawicielMedyczny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rkp")
public class Regionalny {

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
    private String medicalLine;

    @NotBlank
    private String region;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "regionalny")
    private List<PrzedstawicielMedyczny> przedstawicielMedycznyList = new ArrayList<>();

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

    public List<PrzedstawicielMedyczny> getPrzedstawicielMedycznyList() {
        return przedstawicielMedycznyList;
    }

    public void setPrzedstawicielMedycznyList(List<PrzedstawicielMedyczny> przedstawicielMedycznyList) {
        this.przedstawicielMedycznyList = przedstawicielMedycznyList;
    }
}
