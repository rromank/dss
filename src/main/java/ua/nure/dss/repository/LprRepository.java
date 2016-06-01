package ua.nure.dss.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.dss.domain.Lpr;

import java.util.List;

/**
 * @author Ihor_Prokopov
 */

@Transactional
public interface LprRepository extends PagingAndSortingRepository<Lpr, Long> {

    List<Lpr> findAll();

}