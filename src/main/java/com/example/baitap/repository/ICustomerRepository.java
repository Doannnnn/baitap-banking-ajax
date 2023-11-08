package com.example.baitap.repository;

import com.example.baitap.model.Customer;
import com.example.baitap.model.dto.response.CustomerResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT NEW com.example.baitap.model.dto.response.CustomerResDTO (" +
            "cus.id, " +
            "cus.fullName, " +
            "cus.email, " +
            "cus.phone, " +
            "cus.address, " +
            "cus.balance," +
            "cus.deleted" +
            ") FROM Customer AS cus "
    )
    List<CustomerResDTO> findAllCustomerResDTO();
}
