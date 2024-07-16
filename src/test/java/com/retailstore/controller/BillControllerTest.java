package com.retailstore.controller;

import com.retailstore.model.Bill;
import com.retailstore.service.BillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BillControllerTest {

    @Mock
    private BillService billService;

    @InjectMocks
    private BillController billController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateNetAmount() {
        Bill bill = new Bill(/* Add constructor arguments */);
        double expectedAmount = 100.0; // Replace with expected amount


        when(billService.calculateFinalAmount(any(Bill.class))).thenReturn(expectedAmount);


        double actualAmount = billController.calculateNetAmount(bill);

        assertEquals(expectedAmount, actualAmount);

        verify(billService, times(1)).calculateFinalAmount(bill);
    }


}
