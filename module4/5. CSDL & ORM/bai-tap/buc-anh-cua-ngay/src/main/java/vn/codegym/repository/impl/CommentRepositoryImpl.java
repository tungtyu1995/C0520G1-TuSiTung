package vn.codegym.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Comment;
import vn.codegym.repository.CommentRepository;
import vn.codegym.repository.ConnectionUtil;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {


    @Override
    public void save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(comment);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Comment> findAll() {
        Session session = null;
        List<Comment> commentList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            commentList = session.createQuery("FROM Comment").getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return commentList;
    }

    @Override
    public Comment findById(Long id) {
        Session session = null;
        Comment comment = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();

            comment = session.get(Comment.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return comment;
    }

    @Override
    public void update(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(comment);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}