/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.CommentaireNoteDao;
import dao.MatiereDao;
import dao.NoteCoursDao;
import dao.UserDao;
import entities.CommentaireNote;
import entities.Matiere;
import entities.NoteCours;
import entities.User;
import util.HibernateUtil;

/**
 *
 * @author Yoga
 */
public class Test {

    public static void main(String[] args) {
        MatiereDao md = new MatiereDao();
        NoteCoursDao nc = new NoteCoursDao();
        UserDao ud = new UserDao();
        CommentaireNoteDao cd = new CommentaireNoteDao();
        
        //Créer des matières :
        //md.create(new Matiere("Informatique"));
        //md.create(new Matiere("Math"));
        
        //md.delete(md.findById(1));
        
        //for(Matiere m : md.findAll())
         //System.out.println(m.getNom());
        
        //Créer une note de cours :
        //nc.create(new NoteCours("TD1", 15.5 , md.findById(2)));
        //nc.create(new NoteCours("Algo", 15.5 , md.findById(3)));
        
        
        //Afficher les notes d'une matière :
        //for(NoteCours n : md.findById(3).getNoteCourss())
        //System.out.println(n.getContenu());
        
        //  Créer un utilisateur :
         //ud.create(new User("Salma", "salma@example.com", "123456"));
         //ud.create(new User("Amal", "amal@example.com", "amal12"));
        
        // Créer un commentaire pour une note donnée par un user
        // cd.create(new CommentaireNote("Bien", ud.findById(1), nc.findById(1)));
         //cd.create(new CommentaireNote("Très proche!", ud.findById(2), nc.findById(1)));
        cd.create(new CommentaireNote("Bon travail", ud.findById(1), nc.findById(2)));
        
        //Afficher les commentaires écrits par un utilisateur
        //System.out.println("Commentaires pour la note : " + nc.findById(2).getContenu());
        //for (CommentaireNote c : nc.findById(1).getCommentaires()) {
         //   System.out.println("- " + c.getContenu() + " (par : " + c.getUser().getNom() + ")");
        //}
        
        // Afficher tous les commentaires d'une note
        System.out.println("Commentaires écrits par : " + ud.findById(2).getNom());
        for (CommentaireNote c : ud.findById(1).getCommentaires()) {
            System.out.println("- " + c.getContenu() + " (sur : " + c.getNote().getTitre() + ")");
        }
    }
}
