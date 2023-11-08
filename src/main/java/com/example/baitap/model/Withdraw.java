package com.example.baitap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "withdraws")
public class Withdraw implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    private BigDecimal transactionAmount;
    private LocalDateTime dateWithdrawal;
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Withdraw withdraw = (Withdraw) o;
        BigDecimal transactionAmount = withdraw.transactionAmount;

        if (transactionAmount == null) {
            errors.rejectValue("transactionAmount", "withdraw.transactionAmount.null");
            return;
        }
        if (transactionAmount.compareTo(BigDecimal.TEN) < 0) {
            errors.rejectValue("transactionAmount", "withdraw.transactionAmount.min");
            return;
        }
        if (transactionAmount.compareTo(BigDecimal.valueOf(1000000000)) > 0) {
            errors.rejectValue("transactionAmount", "withdraw.transactionAmount.max");
            return;
        }
        if (transactionAmount.compareTo(withdraw.getCustomer().getBalance()) > 0) {
            errors.rejectValue("transactionAmount", "withdraw.transactionAmount.check");
            return;
        }
    }
}
