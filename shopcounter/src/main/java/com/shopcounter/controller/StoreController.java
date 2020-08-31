package com.shopcounter.controller;

import com.shopcounter.controller.dto.BillingDto;
import com.shopcounter.model.Bill;
import com.shopcounter.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/counter")
public class StoreController {

    @Autowired
    private StoreService<Bill, BillingDto> billingRequestStoreService;

    @PostMapping(value = "/bill", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewBill(@RequestBody BillingDto request) {
        return new ResponseEntity(billingRequestStoreService.create(request), HttpStatus.OK);
    }

    @GetMapping(value = "/bill/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findBill(@PathVariable("id") int id) {
        return new ResponseEntity(billingRequestStoreService.find(id), HttpStatus.OK);
    }

    @GetMapping(value = "/bill", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllBills() {
        return new ResponseEntity(billingRequestStoreService.find(), HttpStatus.OK);
    }
}
