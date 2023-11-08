package com.example.baitap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.springframework.validation.Validator;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "deposits")
public class Deposit implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    private BigDecimal transactionAmount;
    private LocalDateTime dateDeposit;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Deposit deposit = (Deposit) o;
        BigDecimal transactionAmount = deposit.transactionAmount;

        if (transactionAmount == null) {
            errors.rejectValue("transactionAmount", "deposit.transactionAmount.null");
            return;
        }
        if (transactionAmount.compareTo(BigDecimal.TEN) < 0) {
            errors.rejectValue("transactionAmount", "deposit.transactionAmount.min");
            return;
        }
        if (transactionAmount.compareTo(BigDecimal.valueOf(1000000000)) > 0) {
            errors.rejectValue("transactionAmount", "deposit.transactionAmount.max");
            return;
        }
    }
}
