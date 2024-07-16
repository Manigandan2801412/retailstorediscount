package com.retailstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.retailstore.model.Bill;
import com.retailstore.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BillService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class BillServiceTest {
    @Autowired
    private BillService billService;

    @MockBean
    private DiscountService discountService;

    @Test
    void testCalculateFinalAmount() {

        when(discountService.calculateBestDiscount(Mockito.<User>any(), anyDouble())).thenReturn(10.0d);
        Bill.BillBuilder totalAmountResult = Bill.builder().amount(10.0d).itemType("Item Type").totalAmount(10.0d);
        User user = User.builder().customerDuration(1).build();
        Bill bill = totalAmountResult.user(user).build();


        double actualCalculateFinalAmountResult = billService.calculateFinalAmount(bill);


        verify(discountService).calculateBestDiscount(isA(User.class), eq(10.0d));
        assertEquals(0.0d, actualCalculateFinalAmountResult);
    }

    @Test
    void testCalculateFinalAmount2() {
        Bill.BillBuilder totalAmountResult = Bill.builder().amount(10.0d).itemType("Groceries").totalAmount(10.0d);
        User user = User.builder().customerDuration(1).build();
        Bill bill = totalAmountResult.user(user).build();

        assertEquals(10.0d, billService.calculateFinalAmount(bill));
    }
}
