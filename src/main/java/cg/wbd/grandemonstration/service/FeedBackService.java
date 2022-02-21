package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.FeedBack;

import java.util.List;

public interface FeedBackService {
    List<FeedBack> findAll();

    void addFeedBack(FeedBack feedback);
    void updateById(FeedBack feedback);
    FeedBack getById(Long id);
}
