package com.retailstore.controller;

import com.retailstore.model.Bill;
import com.retailstore.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/calculate")
    public double calculateNetAmount(@RequestBody Bill bill) {
        return billService.calculateFinalAmount(bill);
    }
}
