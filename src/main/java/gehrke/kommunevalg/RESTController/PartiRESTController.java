package gehrke.kommunevalg.RESTController;

import gehrke.kommunevalg.model.Kandidat;
import gehrke.kommunevalg.model.Parti;
import gehrke.kommunevalg.repos.PartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PartiRESTController {

    @Autowired
    PartiRepository partiRepository;

    @GetMapping("/parti")
    public List<Parti> getAllPartier(){
        return partiRepository.findAll();
    }

    @PutMapping(value = "/parti", consumes = "application/json")
    public ResponseEntity<Parti> updateParti(@RequestBody Parti parti){
        Optional<Parti> data = partiRepository.findById(parti.getPartiId());
        if(data.isPresent()){
            Parti updatedParti = data.get();
            updatedParti.setName(parti.getName());
            updatedParti.setVotes(parti.getVotes());
            updatedParti.setPartiLetter(parti.getPartiLetter());

            partiRepository.save(updatedParti);
        }
        return new ResponseEntity<>(parti, HttpStatus.OK);
    }
}
