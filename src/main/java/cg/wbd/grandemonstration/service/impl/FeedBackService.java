package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.FeedBack;
import cg.wbd.grandemonstration.repository.IFeedbackRepository;
import cg.wbd.grandemonstration.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService implements IFeedBackService {
    @Autowired
    public IFeedbackRepository iFeedbackRepository;
    @Override
    public List<FeedBack> findAll() {
        return iFeedbackRepository.findAll();
    }

    @Override
    public void addFeedBack(FeedBack feedBack) {
        iFeedbackRepository.addFeedBack(feedBack);
    }

    @Override
    public void updateById(FeedBack feedBack) {
        iFeedbackRepository.updateById(feedBack);
    }



    @Override
    public FeedBack getById(Long id) {
        return iFeedbackRepository.getById(id);
    }
}
