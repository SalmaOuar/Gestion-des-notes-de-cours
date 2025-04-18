/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class NoteCours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private double contenu;
    @ManyToOne
    private Matiere matiere;
    @OneToMany(mappedBy = "note", fetch = FetchType.EAGER)
    private List<CommentaireNote> commentaires;
    @ManyToOne
    private Enseignant enseignant;

    public NoteCours() {
    }

    public NoteCours(String titre, double contenu, Matiere matiere, Enseignant enseignant) {
        this.titre = titre;
        this.contenu = contenu;
        this.matiere = matiere;
        this.enseignant = enseignant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getContenu() {
        return contenu;
    }

    public void setContenu(double contenu) {
        this.contenu = contenu;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public List<CommentaireNote> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<CommentaireNote> commentaires) {
        this.commentaires = commentaires;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

}
