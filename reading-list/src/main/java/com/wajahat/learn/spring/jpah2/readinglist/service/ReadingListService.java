package com.wajahat.learn.spring.jpah2.readinglist.service;

import com.wajahat.learn.spring.jpah2.readinglist.domain.Book;
import com.wajahat.learn.spring.jpah2.readinglist.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wajahat on 16/5/17.
 */
@Service
public class ReadingListService {

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListService(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    public List<Book> getBooks() {
        return readingListRepository.findAll();
    }

    public List<Book> getReadingListByReader(String reader) {
        return readingListRepository.findByReader(reader);
    }

    public Book addBook(Book book) {
        return readingListRepository.save(book);
    }
}
