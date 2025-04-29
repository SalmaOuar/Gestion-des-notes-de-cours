/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Enseignant;
import entities.NoteCours;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Yoga
 */
public class NoteCoursDao implements IDao<NoteCours> {

    @Override
    public boolean create(NoteCours o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean delete(NoteCours o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean update(NoteCours o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public List<NoteCours> findAll() {
        Session session = null;
        Transaction tx = null;
        List<NoteCours> noteCours = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            noteCours = session.createQuery("from NoteCours").list();
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
        return noteCours;
    }

    @Override
    public NoteCours findById(int id) {
        Session session = null;
        Transaction tx = null;
        NoteCours noteCours = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            noteCours = (NoteCours) session.get(NoteCours.class, id);
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
        return noteCours;
    }

    public List<NoteCours> findByEnseignant(Enseignant enseignant) {
        Session session = null;
        Transaction tx = null;
        List<NoteCours> notes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            notes = session.createQuery("from NoteCours where enseignant.id = :id")
                    .setParameter("id", enseignant.getId())
                    .list();
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
        return notes;
    }

    public List<NoteCours> findByEnseignantWithCommentaires(Enseignant ens) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<NoteCours> notes = null;

        try {
            tx = session.beginTransaction();

            notes = session.createQuery(
                    "SELECT DISTINCT n FROM NoteCours n "
                    + "LEFT JOIN FETCH n.commentaires "
                    + "JOIN FETCH n.matiere "
                    + "WHERE n.enseignant.id = :id")
                    .setParameter("id", ens.getId())
                    .list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return notes;
    }

}
