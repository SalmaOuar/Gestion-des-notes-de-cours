package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "commentairenote")
public class CommentaireNote implements Serializable  {

     @EmbeddedId
    private CommentaireNotePK id;

    private String contenu;

    @ManyToOne
    @MapsId("noteId")
    @JoinColumn(name = "note_id", referencedColumnName = "id")
    private NoteCours note;

    @ManyToOne
    @MapsId("enseignantId")
    @JoinColumn(name = "enseignant_id", referencedColumnName = "id")
    private Enseignant enseignant;

    public CommentaireNote() {}

    public CommentaireNote(String contenu, NoteCours note, Enseignant enseignant) {
        this.note = note;
        this.enseignant = enseignant;
        this.contenu = contenu;
        this.id = new CommentaireNotePK(enseignant.getId(), note.getId());
    }

    public CommentaireNotePK getId() {
        return id;
    }

    public void setId(CommentaireNotePK id) {
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
