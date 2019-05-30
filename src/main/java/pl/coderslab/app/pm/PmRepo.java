package pl.coderslab.app.pm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PmRepo extends JpaRepository<PrzedstawicielMedyczny, Long> {

    PrzedstawicielMedyczny findByEmail(String email);

}

