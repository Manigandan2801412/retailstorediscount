package com.retailstore.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Bill {
    private double totalAmount;
    private double amount;
    private String itemType;
    private User user;

}
