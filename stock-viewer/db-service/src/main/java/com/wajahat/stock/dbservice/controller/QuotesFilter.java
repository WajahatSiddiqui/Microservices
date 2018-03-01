package com.wajahat.stock.dbservice.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * db-service - Filter for creating Quotes
 *
 * @author Wajahat Siddiqui
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuotesFilter {
    @NotNull(message = "userName cannot be null")
    private String userName;
    @NotNull(message = "quotes cannot be null")
    private List<String> quotes;
}
