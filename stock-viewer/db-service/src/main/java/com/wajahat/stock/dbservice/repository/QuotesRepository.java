package com.wajahat.stock.dbservice.repository;

import com.wajahat.stock.dbservice.domain.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * db-service - JpaRepository for {@link Quotes}
 *
 * @author Wajahat Siddiqui
 */
@Repository
public interface QuotesRepository extends JpaRepository<Quotes, Long> {
    List<Quotes> findByUserName(String userName);
}
