/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.AdminDao;
import entities.Admin;

/**
 *
 * @author Yoga
 */
public class TestAdmin {
     public static void main(String[] args) {
        AdminDao adminDao = new AdminDao();

        Admin admin = new Admin("Admin Ahmed", "admin@pf.com", "admin123");
        boolean success = adminDao.create(admin);

        if (success) {
            System.out.println("Admin inséré avec succès !");
        } else {
            System.out.println("Échec de l'insertion.");
        }
    }
}
