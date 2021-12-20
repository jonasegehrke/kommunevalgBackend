package gehrke.kommunevalg.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@ToString

@Entity
public class Parti {

    @Id
    private int partiId;
    private String name;
    private int votes;
    private char partiLetter;

    @OneToMany
    @JoinColumn(name = "partiId")
    @JsonBackReference
    private Set<Kandidat> kandidater = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parti parti = (Parti) o;
        return partiId == parti.partiId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partiId);
    }
}
