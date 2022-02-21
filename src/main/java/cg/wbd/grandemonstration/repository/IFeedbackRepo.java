package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.FeedBack;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeedbackRepo extends PagingAndSortingRepository<FeedBack,Long> {
}
