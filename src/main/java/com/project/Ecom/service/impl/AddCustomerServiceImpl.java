package com.project.Ecom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Ecom.dto.customer_dto.CreateCustomerDTO;
import com.project.Ecom.entity.Customer;
import com.project.Ecom.entity.DeliveryAddress;
import com.project.Ecom.repository.CustomerRepository;
import com.project.Ecom.service.IAddCustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddCustomerServiceImpl implements IAddCustomerService {

    private CustomerRepository customerRepository;

    @Override
    public String addCustomer(CreateCustomerDTO createCustomerDTO) {

        Customer customer = new Customer();

        customer.setCustomerName(createCustomerDTO.getCustomerName());
        customer.setEmailId(createCustomerDTO.getEmailId());
        customer.setPhoneNo(createCustomerDTO.getPhoneNo());

        DeliveryAddress deliveryAddress = new DeliveryAddress();

        deliveryAddress.setAddress1(createCustomerDTO.getAddress1());
        deliveryAddress.setPinCode(createCustomerDTO.getPinCode());

        deliveryAddress.setCustomer(customer);

        customer.setDeliveryAddress(List.of(deliveryAddress));

        customerRepository.save(customer);

        return "Customer is added successfully";
    }

}
