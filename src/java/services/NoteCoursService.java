/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.NoteCoursDao;
import entities.NoteCours;
import java.util.List;

/**
 *
 * @author Yoga
 */
public class NoteCoursService implements IService<NoteCours> {

    private final NoteCoursDao dao;

    public NoteCoursService() {
        this.dao = new NoteCoursDao();
    }

    @Override
    public boolean create(NoteCours o) {
        return dao.create(o);
    }

    @Override
    public boolean delete(NoteCours o) {
        return dao.delete(o);
    }

    @Override
    public boolean update(NoteCours o) {
        return dao.update(o);
    }

    @Override
    public List<NoteCours> findAll() {
        return dao.findAll();
    }

    @Override
    public NoteCours findById(int id) {
        return dao.findById(id);
    }
}
