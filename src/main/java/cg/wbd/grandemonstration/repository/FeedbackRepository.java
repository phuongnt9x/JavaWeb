package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.FeedBack;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class FeedbackRepository implements IFeedbackRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<FeedBack> findAll() {
        TypedQuery<FeedBack> query = entityManager.createQuery("select c from FeedBack c", FeedBack.class);
        return query.getResultList();
    }

    @Override
    public void addFeedBack(FeedBack feedBack) {
        if(feedBack.getId() != null){
            entityManager.merge(feedBack);
        } else {
            entityManager.persist(feedBack);
        }

    }

    @Override
    public void updateById(FeedBack feedBack) {
        entityManager.merge(feedBack);

    }

    @Override
    public FeedBack getById(Long id) {
        TypedQuery<FeedBack> query = entityManager.createQuery("select c from FeedBack c where  c.id=:id", FeedBack.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
