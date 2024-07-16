package com.retailstore.service;

import com.retailstore.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountServiceTest {

    private DiscountService discountService = new DiscountService();

    @Test
    public void testCalculateBestDiscountEmployee() {
        User user = new User();
        user.setEmployee(true);
        double discount = discountService.calculateBestDiscount(user, 200);
        assertEquals(60.0, discount);
    }

    @Test
    public void testCalculateBestDiscountAffiliate() {
        User user = new User();
        user.setAffiliate(true);
        double discount = discountService.calculateBestDiscount(user, 200);
        assertEquals(20.0, discount);
    }

    @Test
    public void testCalculateBestDiscountLoyalCustomer() {
        User user = new User();
        user.setCustomerDuration(3);
        double discount = discountService.calculateBestDiscount(user, 200);
        assertEquals(10.0, discount);
    }
}
