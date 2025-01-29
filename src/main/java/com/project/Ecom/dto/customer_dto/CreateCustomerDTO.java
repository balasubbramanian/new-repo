package com.project.Ecom.dto.customer_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerDTO {

    private String customerName;

    private String emailId;

    private String phoneNo;
    private String address1;

    private int pinCode;

}
