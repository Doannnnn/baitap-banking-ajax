package com.example.baitap.controller.restController;

import com.example.baitap.model.Customer;
import com.example.baitap.model.dto.request.CustomerReqDTO;
import com.example.baitap.model.dto.response.CustomerResDTO;
import com.example.baitap.service.customer.ICustomerService;
import com.example.baitap.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private AppUtils appUtils;

    @GetMapping
    public ResponseEntity<?> findAllCustomer() {

        List<CustomerResDTO> customerResDTOS = customerService.findAllCustomerResDTO();

        return new ResponseEntity<>(customerResDTOS, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> findByIdCustomer(@PathVariable Long customerId) {

        Optional<Customer> customerOptional = customerService.findById(customerId);
        Customer customer = customerOptional.get();

        CustomerResDTO customerResDTO = customer.toCustomerResDTO();

        return new ResponseEntity<>(customerResDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerReqDTO customerReqDTO, BindingResult bindingResult) {

        new CustomerReqDTO().validate(customerReqDTO, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Customer customer = new Customer();
        customer.setFullName(customerReqDTO.getFullName());
        customer.setEmail(customerReqDTO.getEmail());
        customer.setPhone(customerReqDTO.getPhone());
        customer.setAddress(customerReqDTO.getAddress());
        customer.setBalance(BigDecimal.ZERO);
        customer.setDeleted(false);

        customerService.create(customer);

        CustomerResDTO customerResDTO = customer.toCustomerResDTO();

        return new ResponseEntity<>(customerResDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerReqDTO customerReqDTO, BindingResult bindingResult){

        new CustomerReqDTO().validate(customerReqDTO, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        return new ResponseEntity<>(customerReqDTO, HttpStatus.OK);
    }
}
