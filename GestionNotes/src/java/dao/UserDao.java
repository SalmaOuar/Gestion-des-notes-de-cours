/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Yoga
 */
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
    }

    public User findById(int id) {
        Session session = null;
        Transaction tx = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            user = (User) session.get(User.class, id);

            if (user != null) {
                Hibernate.initialize(user.getCommentaires());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

}
