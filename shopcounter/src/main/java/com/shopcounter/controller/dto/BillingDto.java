package com.shopcounter.controller.dto;


import lombok.Data;

import java.util.List;


@Data
public class BillingDto {
    private List<BillItemsDto> purchase;
}
