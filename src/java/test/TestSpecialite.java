/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.EnseignantDao;
import entities.Enseignant;
import java.util.List;

/**
 *
 * @author Yoga
 */
public class TestSpecialite {
    public static void main(String[] args) {
        EnseignantDao ed = new EnseignantDao();

        List<Enseignant> enseignants = ed.findBySpecialite("Mathématiques");

        if (!enseignants.isEmpty()) {
            System.out.println("Enseignants de spécialité 'Mathématiques' :");
            for (Enseignant e : enseignants) {
                System.out.println("- " + e.getNom() + " (" + e.getEmail() + ")");
            }
        } else {
            System.out.println("Aucun enseignant trouvé pour la spécialité 'Mathématiques'.");
        }
    }
}
