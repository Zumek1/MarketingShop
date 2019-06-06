package pl.coderslab.app.pm;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.rkp.Regionalny;

import java.util.List;

public interface PmRepo extends JpaRepository<PrzedstawicielMedyczny, Long> {

    PrzedstawicielMedyczny findByEmail(String email);
    List<PrzedstawicielMedyczny> findByRegionalny(Regionalny regionalny);

}

