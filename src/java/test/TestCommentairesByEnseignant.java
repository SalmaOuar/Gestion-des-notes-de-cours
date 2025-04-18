/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.EnseignantDao;
import entities.CommentaireNote;
import entities.Enseignant;

/**
 *
 * @author Yoga
 */
public class TestCommentairesByEnseignant {
    public static void main(String[] args) {
        EnseignantDao ed = new EnseignantDao();

        
        Enseignant e = ed.findByIdWithCommentaires(3); 

        if (e != null && e.getCommentaires() != null && !e.getCommentaires().isEmpty()) {
            System.out.println("Commentaires de " + e.getNom() + " :");
            for (CommentaireNote c : e.getCommentaires()) {
                System.out.println("- " + c.getContenu() + " (sur : " + c.getNote().getTitre() + ")");
            }
        } else {
            System.out.println("Aucun commentaire trouvé pour l'enseignant.");
        }
    }
}
