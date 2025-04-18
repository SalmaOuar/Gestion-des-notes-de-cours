/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.AdminDao;
import entities.Admin;
import java.util.List;

/**
 *
 * @author Yoga
 */
public class AdminService extends UserService {

    private final AdminDao dao;

    public AdminService() {
        this.dao = new AdminDao();
    }

    public boolean create(Admin o) {
        return dao.create(o);
    }

    public boolean delete(Admin o) {
        return dao.delete(o);
    }

    public boolean update(Admin o) {
        return dao.update(o);
    }

    public List<Admin> findAllAdmins() {
        return dao.findAll();
    }

    @Override
    public Admin findById(int id) {
        return dao.findById(id);
    }
}
