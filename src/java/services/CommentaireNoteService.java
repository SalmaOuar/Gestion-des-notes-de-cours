/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CommentaireNoteDao;
import entities.CommentaireNote;
import java.util.List;

/**
 *
 * @author Yoga
 */
public class CommentaireNoteService implements IService<CommentaireNote> {

    private final CommentaireNoteDao dao;

    public CommentaireNoteService() {
        this.dao = new CommentaireNoteDao();
    }

    @Override
    public boolean create(CommentaireNote o) {
        return dao.create(o);
    }

    @Override
    public boolean delete(CommentaireNote o) {
        return dao.delete(o);
    }

    @Override
    public boolean update(CommentaireNote o) {
        return dao.update(o);
    }

    @Override
    public List<CommentaireNote> findAll() {
        return dao.findAll();
    }

    @Override
    public CommentaireNote findById(int id) {
        return dao.findById(id);
    }
}
