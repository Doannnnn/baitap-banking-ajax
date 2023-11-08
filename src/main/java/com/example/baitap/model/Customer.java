package com.example.baitap.model;

import com.example.baitap.model.dto.response.CustomerResDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank()
    private String fullName;

    @NotBlank()
    private String email;

    @NotBlank()
    private String phone;

    @NotBlank()
    private String address;

    private BigDecimal balance;

    private Boolean deleted;

    public CustomerResDTO toCustomerResDTO() {
        CustomerResDTO customerResDTO = new CustomerResDTO();
        customerResDTO.setId(id);
        customerResDTO.setFullName(fullName);
        customerResDTO.setEmail(email);
        customerResDTO.setPhone(phone);
        customerResDTO.setBalance(balance);
        customerResDTO.setAddress(address);
        customerResDTO.setDeleted(deleted);

        return customerResDTO;
    }
}
