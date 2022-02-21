package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.FeedBack;
import cg.wbd.grandemonstration.repository.IFeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepo feedbackRepo;
    @Override
    public Page<FeedBack> findAll(Pageable pageable) {
        return feedbackRepo.findAll(pageable);
    }

    @Override
    public FeedBack findById(Long id) {
        return feedbackRepo.findById(id).get();
    }

    @Override
    public void save(FeedBack feedBack) {
        feedbackRepo.save(feedBack);

    }
}
