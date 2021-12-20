package gehrke.kommunevalg.repos;

import gehrke.kommunevalg.model.Kandidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KandidatRepository extends JpaRepository<Kandidat, Integer> {

    List<Kandidat> findKandidatsByPartiName(String partiName);
    List<Kandidat> findAllByOrderByPartiDesc();

}
