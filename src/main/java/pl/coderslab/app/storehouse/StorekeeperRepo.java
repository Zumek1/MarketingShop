package pl.coderslab.app.storehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.rkp.Regionalny;

public interface StorekeeperRepo extends JpaRepository<Storekeeper,Long> {
    Storekeeper findByEmail(String email);
}
