/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.EnseignantDao;
import entities.Enseignant;
import entities.NoteCours;

/**
 *
 * @author Yoga
 */
public class TestNotesByEnseignant {
    public static void main(String[] args) {
        EnseignantDao ed = new EnseignantDao();

        
        Enseignant e = ed.findById(2); 

        System.out.println("Notes créées par : " + e.getNom());
        for (NoteCours n : ed.findNotesByEnseignant(e)) {
            System.out.println("- " + n.getTitre() + " (Note : " + n.getContenu() + ")");
        }
    }
}
