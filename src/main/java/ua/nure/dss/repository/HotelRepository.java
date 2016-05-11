package ua.nure.dss.repository;

import ua.nure.dss.domain.Hotel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {

}