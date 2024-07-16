package com.retailstore.service;

import com.retailstore.model.User;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public double calculateBestDiscount(User user, double totalAmount) {
        double discount = 0;

        if (user.isEmployee()) {
            discount = totalAmount * 0.30;
        } else if (user.isAffiliate()) {
            discount = totalAmount * 0.10;
        } else if (user.getCustomerDuration() > 2) {
            discount = totalAmount * 0.05;
        }

        return discount;
    }
}
