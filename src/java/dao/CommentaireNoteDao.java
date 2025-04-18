package dao;

import entities.CommentaireNote;
import entities.Enseignant;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Yoga
 */
public class CommentaireNoteDao extends AbstractDao<CommentaireNote> {

    public CommentaireNoteDao() {
        super(CommentaireNote.class);
    }

    public List<CommentaireNote> findByEnseignant(Enseignant enseignant) {
    Session session = null;
    Transaction tx = null;
    List<CommentaireNote> commentaires = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        commentaires = session.createQuery("from CommentaireNote where enseignant.id = :id")
                              .setParameter("id", enseignant.getId())
                              .list();

        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
    } finally {
        if (session != null) session.close();
    }

    return commentaires;
}
}
