package ua.nure.dss.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.dss.domain.Mark;

import java.util.List;

@Transactional
public interface MarkRepository extends PagingAndSortingRepository<Mark, Long> {

    List<Mark> findAll();

}