package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.FeedBack;
import cg.wbd.grandemonstration.service.FeedBackService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class HibernateFeedBackService implements FeedBackService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<FeedBack> findAll() {
        String queryStr = "SELECT f FROM FeedBack AS f";
        TypedQuery<FeedBack> query = entityManager.createQuery(queryStr, FeedBack.class);
        return query.getResultList();
    }

    @Override
    public void addFeedBack(FeedBack feedBack) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(feedBack);
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
    public void updateById(FeedBack feedBack) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
           session.update(feedBack);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }



    @Override
    public FeedBack getById(Long id) {
        String queryStr = "SELECT f FROM FeedBack AS f WHERE f.id = :id";
        TypedQuery<FeedBack> query = entityManager.createQuery(queryStr, FeedBack.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
