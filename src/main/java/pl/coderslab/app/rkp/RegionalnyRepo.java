package pl.coderslab.app.rkp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionalnyRepo  extends JpaRepository<Regionalny,Long> {
    Regionalny findByEmail(String email);
}
