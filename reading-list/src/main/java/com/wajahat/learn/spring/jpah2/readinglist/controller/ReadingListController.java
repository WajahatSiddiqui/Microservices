package com.wajahat.learn.spring.jpah2.readinglist.controller;

import com.wajahat.learn.spring.jpah2.readinglist.domain.Book;
import com.wajahat.learn.spring.jpah2.readinglist.service.ReadingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wajahat on 16/5/17.
 */
@Controller
@RequestMapping("/readinglist")
public class ReadingListController {


    private ReadingListService readingListService;

    @Autowired
    public ReadingListController(ReadingListService readingListService) {
        this.readingListService = readingListService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        List<Book> readingList = readingListService.getBooks();
        if (readingList != null && !readingList.isEmpty()) {
            model.addAttribute("books", readingList);
        }
        return "books";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String getReadingList(@PathVariable("reader") String reader, @RequestBody  Model model) {
        List<Book> readingList = readingListService.getBooks();
        if (readingList != null && !readingList.isEmpty()) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, @RequestBody  Book book) {
        book.setReader(reader);
        readingListService.addBook(book);
        return "redirect:/{reader}";
    }
}
