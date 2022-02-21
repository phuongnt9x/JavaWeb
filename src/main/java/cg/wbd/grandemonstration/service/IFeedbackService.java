package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.FeedBack;
import cg.wbd.grandemonstration.repository.IFeedbackRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFeedbackService {
    Page<FeedBack> findAll(Pageable pageable);
    FeedBack findById(Long id);
    void save(FeedBack feedBack);

}
