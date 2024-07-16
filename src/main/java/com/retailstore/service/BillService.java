package com.retailstore.service;

import com.retailstore.model.Bill;
import com.retailstore.util.DiscountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private DiscountService discountService;

    public double calculateFinalAmount(Bill bill) {
        double finalAmount = bill.getTotalAmount();

        if (bill.getItemType().equalsIgnoreCase("Groceries")) {
            finalAmount -= DiscountUtil.calculateGroceriesDiscount(bill.getTotalAmount());
        } else {
            finalAmount -= discountService.calculateBestDiscount(bill.getUser(), bill.getTotalAmount());
        }

        finalAmount -= DiscountUtil.calculateBillDiscount(finalAmount);
        return finalAmount;
    }
}
