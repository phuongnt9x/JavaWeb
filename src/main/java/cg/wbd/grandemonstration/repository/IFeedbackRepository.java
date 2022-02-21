package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.FeedBack;

import java.util.List;

public interface IFeedbackRepository {
    List<FeedBack> findAll();

    void addFeedBack(FeedBack feedBack);
    void updateById(FeedBack feedBack);
    FeedBack getById(Long id);
}
