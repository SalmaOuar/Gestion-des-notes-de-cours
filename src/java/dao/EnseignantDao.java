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
public class EnseignantDao extends AbstractDao<Enseignant> {

    public EnseignantDao() {
        super(Enseignant.class);
    }

    public List<Enseignant> findBySpecialite(String specialite) {
        Session session = null;
        Transaction tx = null;
        List<Enseignant> enseignants = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            enseignants = session.getNamedQuery("findBySpecialite")
                    .setParameter("specialite", specialite)
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
        return enseignants;
    }

    public List<NoteCours> findNotesByEnseignant(Enseignant enseignant) {
        Session session = null;
        Transaction tx = null;
        List<NoteCours> notes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            notes = session.getNamedQuery("findNotesByEnseignant")
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

    public Enseignant findByIdWithCommentaires(int id) {
        Session session = null;
        Transaction tx = null;
        Enseignant enseignant = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            enseignant = (Enseignant) session.get(Enseignant.class, id);

            if (enseignant != null && enseignant.getCommentaires() != null) {

                enseignant.getCommentaires().size();
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

        return enseignant;
    }
}
