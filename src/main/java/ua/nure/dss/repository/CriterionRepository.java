package ua.nure.dss.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.dss.domain.Criterion;

import java.util.List;

@Transactional
public interface CriterionRepository extends PagingAndSortingRepository<Criterion, Long> {

    List<Criterion> findAll();

}