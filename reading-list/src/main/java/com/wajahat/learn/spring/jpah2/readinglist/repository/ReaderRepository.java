package com.wajahat.learn.spring.jpah2.readinglist.repository;

import com.wajahat.learn.spring.jpah2.readinglist.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wajahat on 16/5/17.
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {
}
