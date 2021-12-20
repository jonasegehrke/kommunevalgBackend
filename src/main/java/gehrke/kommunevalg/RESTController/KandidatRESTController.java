package gehrke.kommunevalg.RESTController;

import gehrke.kommunevalg.model.Kandidat;
import gehrke.kommunevalg.repos.KandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class KandidatRESTController {

    @Autowired
    KandidatRepository kandidatRepository;

    @GetMapping("/kandidat")
    public List<Kandidat> getAllKandidater(){
        return kandidatRepository.findAllByOrderByPartiDesc();
    }

    @GetMapping("/kandidat/{name}")
    public List<Kandidat> getKandidaterFromParti(@PathVariable String name){
        return kandidatRepository.findKandidatsByPartiName(name);
    }

    @PostMapping(value = "/kandidat", consumes = "application/json")
    public ResponseEntity<Kandidat> newKandidat(@RequestBody Kandidat kandidat){
        kandidatRepository.save(kandidat);
        return new ResponseEntity<Kandidat>(kandidat, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/kandidat/{id}")
    public ResponseEntity<Kandidat> deleteKandidat(@PathVariable int id){
        kandidatRepository.deleteById(id);
        return new ResponseEntity<Kandidat>(HttpStatus.OK);
    }

    @PutMapping(value = "/kandidat", consumes = "application/json")
    public ResponseEntity<Kandidat> updateKandidat(@RequestBody Kandidat kandidat){
        Optional<Kandidat> data = kandidatRepository.findById(kandidat.getKandidatId());
        if(data.isPresent()){
            Kandidat updatedKandidat = data.get();
            updatedKandidat.setName(kandidat.getName());
            updatedKandidat.setVotes(kandidat.getVotes());
            updatedKandidat.setParti(kandidat.getParti());

            kandidatRepository.save(updatedKandidat);
        }
        return new ResponseEntity<>(kandidat, HttpStatus.OK);
    }
}
