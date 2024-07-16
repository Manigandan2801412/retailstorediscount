package com.retailstore.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private boolean isEmployee;
    private boolean isAffiliate;
    private int customerDuration;

}

