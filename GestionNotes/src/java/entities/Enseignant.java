/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Enseignant extends User {

    private String specialite;

    @OneToMany(mappedBy = "enseignant")
    private List<NoteCours> notes;

    @OneToMany(mappedBy = "enseignant")
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
