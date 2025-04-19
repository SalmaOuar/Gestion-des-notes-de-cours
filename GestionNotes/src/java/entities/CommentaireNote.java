package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommentaireNote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String contenu;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private NoteCours note;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    public CommentaireNote() {
    }

    public CommentaireNote(String contenu, NoteCours note, Enseignant enseignant) {
        this.contenu = contenu;
        this.note = note;
        this.enseignant = enseignant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    public NoteCours getNote() {
        return note;
    }

    public void setNote(NoteCours note) {
        this.note = note;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    
}
