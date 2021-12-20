package gehrke.kommunevalg.repository;


import gehrke.kommunevalg.model.Kandidat;
import gehrke.kommunevalg.repos.KandidatRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class KandidatRepositoryTest {

    @Autowired
    KandidatRepository kandidatRepository;

    @Test
    void findKandidatsByPartyName(){
        List<Kandidat> list = kandidatRepository.findKandidatsByPartiName("Socialdemokratiet");
        Assert.assertFalse(list.isEmpty());
    }
}
