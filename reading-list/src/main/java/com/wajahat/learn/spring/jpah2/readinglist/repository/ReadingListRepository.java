package com.wajahat.learn.spring.jpah2.readinglist.repository;

import com.wajahat.learn.spring.jpah2.readinglist.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wajahat on 16/5/17.
 */
@Repository
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
