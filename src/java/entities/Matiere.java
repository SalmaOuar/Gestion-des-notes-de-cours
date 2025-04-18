package entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Yoga
 */
@Entity
@Table(name = "matieres")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "matiere", fetch = FetchType.EAGER)
    private List<NoteCours> noteCourss;

    public Matiere() {
    }

    public Matiere(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<NoteCours> getNoteCourss() {
        return noteCourss;
    }

    public void setNoteCourss(List<NoteCours> noteCourss) {
        this.noteCourss = noteCourss;
    }

}
