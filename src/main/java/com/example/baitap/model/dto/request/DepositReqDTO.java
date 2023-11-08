package com.example.baitap.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepositReqDTO implements Validator {

    private String customerId;
    private String transactionAmount;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        DepositReqDTO depositReqDTO = (DepositReqDTO) o;
        String transactionAmount = depositReqDTO.transactionAmount;

        if (transactionAmount == null || transactionAmount.isEmpty()) {
            errors.rejectValue("transactionAmount", "transactionAmount.null", "Nhập số tiền cần nạp.");
            return;
        }
        if (transactionAmount.compareTo("10") < 0) {
            errors.rejectValue("transactionAmount", "transactionAmount.min", "Số tiền phải lớn hớn hoặc bằng 10.");
        }
        if (transactionAmount.compareTo("1000000000") > 0) {
            errors.rejectValue("transactionAmount", "transactionAmount.max", "Số tiền phải lớn hớn hoặc bằng 10000000000.");
        }
    }
}
