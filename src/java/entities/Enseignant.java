/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NamedQueries({
    @NamedQuery(name = "findBySpecialite", query = "FROM Enseignant e WHERE e.specialite = :specialite")
})
@NamedNativeQuery(
        name = "findNotesByEnseignant",
        query = "SELECT n.* FROM notecours n WHERE n.enseignant_id = :id",
        resultClass = NoteCours.class
)
@PrimaryKeyJoinColumn(name = "id")
public class Enseignant extends User {

    private String specialite;

    @OneToMany(mappedBy = "enseignant", fetch = FetchType.LAZY)
    private List<NoteCours> notes;

    @OneToMany(mappedBy = "enseignant", fetch = FetchType.LAZY)
    private List<CommentaireNote> commentaires;

    public Enseignant() {
    }

    public Enseignant(String nom, String email, String motDePasse, String specialite) {
        super(nom, email, motDePasse);
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<NoteCours> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteCours> notes) {
        this.notes = notes;
    }

    public List<CommentaireNote> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<CommentaireNote> commentaires) {
        this.commentaires = commentaires;
    }

}
