package ua.nure.dss.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.dss.domain.Alternative;

import java.util.List;

@Transactional
public interface AlternativeRepository extends PagingAndSortingRepository<Alternative, Long> {

    List<Alternative> findAll();

}