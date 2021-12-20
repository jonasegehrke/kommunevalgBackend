package gehrke.kommunevalg.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@ToString

@Entity
public class Kandidat {

    @Id
    @GeneratedValue
    private int kandidatId;
    private String name;
    private int votes;

    @ManyToOne
    @JoinColumn(name ="partiId")
    private Parti parti;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kandidat kandidat = (Kandidat) o;
        return kandidatId == kandidat.kandidatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kandidatId);
    }
}
