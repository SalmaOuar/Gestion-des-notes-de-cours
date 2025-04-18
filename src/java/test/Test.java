/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.CommentaireNoteDao;
import dao.EnseignantDao;
import dao.MatiereDao;
import dao.NoteCoursDao;
import dao.UserDao;
//import dao.UserDao;
import entities.CommentaireNote;
import entities.Enseignant;
import entities.Matiere;
import entities.NoteCours;
//import entities.User;
import util.HibernateUtil;

/**
 *
 * @author Yoga
 */
public class Test {

    public static void main(String[] args) {
       /* HibernateUtil.getSessionFactory();
        MatiereDao md = new MatiereDao();
        NoteCoursDao nc = new NoteCoursDao();
        CommentaireNoteDao cd = new CommentaireNoteDao();
        EnseignantDao ed = new EnseignantDao();
        //UserDao ud = new UserDao();
        */
        MatiereDao matiereDao = new MatiereDao();
        EnseignantDao enseignantDao = new EnseignantDao();
        NoteCoursDao noteCoursDao = new NoteCoursDao();
        CommentaireNoteDao commentaireDao = new CommentaireNoteDao();

        // 1. Créer une matière
        Matiere matiere = new Matiere("Algorithmique");
        matiereDao.create(matiere);

        // 2. Créer un enseignant (hérite de User)
        Enseignant enseignant = new Enseignant("Mme Nadia", "nadia@univ.ma", "nadia123", "Algorithmique");
        enseignantDao.create(enseignant);  // insère dans `users` et `enseignant`

        // 3. Créer une note
        NoteCours note = new NoteCours("Devoir Algo", 14.5, matiere, enseignant);
        noteCoursDao.create(note);

        // 4. Créer un commentaire
        CommentaireNote commentaire = new CommentaireNote("Bonne progression", note, enseignant);
        commentaireDao.create(commentaire);

        System.out.println("✔ Insertion complète réussie !");
    
        
        
       /*
        // Créer des matières
        md.create(new Matiere("Mathématiques"));
        md.create(new Matiere("Informatique"));
        md.create(new Matiere("Physique"));

        // Créer un enseignant
        //Enseignant e1 = new Enseignant("Mme Fatima", "fatima@univ.ma", "ens123", "Mathématiques");
        Enseignant e2 = new Enseignant("M. Karim", "karim@univ.ma", "karimpass", "Informatique");
        //ed.create(e1);
        ed.create(e2);

        // Créer une note de cours
       // NoteCours n1 = new NoteCours("Devoir 1", 18.5, md.findById(1), e1);
        NoteCours n2 = new NoteCours("TP Java", 15.0, md.findById(2), e2);
       // NoteCours n3 = new NoteCours("Examen final", 12.0, md.findById(1), e1);
       // nc.create(n1);
        nc.create(n2);
        //nc.create(n3);

        // Ajouter un commentaire sur les notes
        //cd.create(new CommentaireNote("Très bien", n1, e1));
        cd.create(new CommentaireNote("Correct, mais attention aux erreurs", n2, e2));
        //cd.create(new CommentaireNote("Passable", n3, e1));

        System.out.println("Insertion terminée avec succès !");

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
        // cd.create(new CommentaireNote("Bon travail", ud.findById(1), nc.findById(2)));
        //Afficher les commentaires écrits par un utilisateur
        //System.out.println("Commentaires pour la note : " + nc.findById(2).getContenu());
        //for (CommentaireNote c : nc.findById(1).getCommentaires()) {
        //   System.out.println("- " + c.getContenu() + " (par : " + c.getUser().getNom() + ")");
        //}
        // Afficher tous les commentaires d'une note
        /*System.out.println("Commentaires écrits par : " + ud.findById(2).getNom());
         for (CommentaireNote c : ud.findById(1).getCommentaires()) {
         System.out.println("- " + c.getContenu() + " (sur : " + c.getNote().getTitre() + ")");
         }*/
    }
}
