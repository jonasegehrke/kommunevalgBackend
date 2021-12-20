package gehrke.kommunevalg.repos;

import gehrke.kommunevalg.model.Parti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartiRepository extends JpaRepository<Parti, Integer> {
}
