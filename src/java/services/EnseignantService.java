/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.EnseignantDao;
import entities.Enseignant;
import entities.User;
import java.util.List;

/**
 *
 * @author Yoga
 */
public class EnseignantService extends UserService {

    private final EnseignantDao dao;
    private Object service;

    public EnseignantService() {
        this.dao = new EnseignantDao();
    }

    public boolean create(Enseignant o) {
        return dao.create(o);
    }

    public boolean delete(Enseignant o) {
        return dao.delete(o);
    }

    public boolean update(Enseignant o) {
        return dao.update(o);
    }

    public List<Enseignant> findAllEnseignants() {
        return dao.findAll();
    }

    @Override
    public Enseignant findById(int id) {
        return dao.findById(id);
    }
}
