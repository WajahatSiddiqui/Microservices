package com.wajahat.stock.dbservice.controller;

import com.wajahat.stock.dbservice.domain.Quotes;
import com.wajahat.stock.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * db-service - Rest Controller for Quotes
 *
 * @author Wajahat Siddiqui
 */
@RestController
@RequestMapping("/stock/quotes")
public class QuotesController {
    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping(value = "/{userName}")
    public ResponseEntity <List<String>> getAllQuotes(@PathVariable("userName") String userName)  {
        return ResponseEntity.ok(getQuotes(userName));
    }

    @PostMapping()
    public ResponseEntity<List<String>> create(@RequestBody @Valid QuotesFilter quotesFilter) {
        saveQuotes(quotesFilter);
        return ResponseEntity.ok(getQuotes(quotesFilter.getUserName()));
    }

    private void saveQuotes(@RequestBody @Valid QuotesFilter quotesFilter) {
        quotesFilter.getQuotes().forEach(qf -> quotesRepository.save(Quotes
                        .builder()
                        .userName(quotesFilter.getUserName())
                        .quotes(qf).build()));
    }

    @DeleteMapping(value = "/{userName}")
    public ResponseEntity<?> delete(@PathVariable("userName") String userName) {
        List<Quotes> quotes = quotesRepository.findByUserName(userName);
        quotesRepository.delete(quotes);
        return ResponseEntity.ok(getAllQuotes(userName));
    }

    @PatchMapping()
    public ResponseEntity update(@RequestBody @Valid QuotesFilter quotesFilter) {
        saveQuotes(quotesFilter);
        return ResponseEntity.noContent().build();
    }


    private List<String> getQuotes(String username) {
        return quotesRepository.findByUserName(username).stream()
                .map(Quotes::getQuotes)
                .collect(Collectors.toList());
    }
}
