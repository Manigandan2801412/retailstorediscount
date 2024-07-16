package com.retailstore.util;

public class DiscountUtil {

    public static double calculateGroceriesDiscount(double totalAmount) {
        return 0;
    }

    public static double calculateBillDiscount(double totalAmount) {
        return (int) (totalAmount / 100) * 5;
    }
}
