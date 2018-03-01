package com.wajahat.stock.service.stockservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * stock-service - Quote Pojo Class
 *
 * @author Wajahat Siddiqui
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Quote {
    private String name;
    private BigDecimal price;
}
