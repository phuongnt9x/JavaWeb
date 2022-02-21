package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.FeedBack;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();

    void addFeedBack(T t);
    void updateById(T t);
    T getById(Long id);

}
