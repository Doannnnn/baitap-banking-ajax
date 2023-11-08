package com.example.baitap.model.dto.request;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class WithdrawReqDTO implements Validator {
    private String customerId;
    private String transactionAmount;
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        WithdrawReqDTO withdrawReqDTO = (WithdrawReqDTO) o;
        String transactionAmount = withdrawReqDTO.transactionAmount;

        if (transactionAmount == null || transactionAmount.isEmpty()) {
            errors.rejectValue("transactionAmount", "transactionAmount.null", "Nhập số tiền cần rút.");
            return;
        }
        if (transactionAmount.compareTo("10") < 0) {
            errors.rejectValue("transactionAmount", "transactionAmount.min", "Số tiền phải lớn hớn hoặc bằng 10.");
            return;
        }
        if (transactionAmount.compareTo("1000000000") > 0) {
            errors.rejectValue("transactionAmount", "transactionAmount.max", "Số tiền phải lớn hớn hoặc bằng 10000000000.");
            return;
        }
//        if (transactionAmount.compareTo(withdraw.getCustomer().getBalance()) > 0) {
//            errors.rejectValue("transactionAmount", "transactionAmount.check", "Số dư không đủ.");
//            return;
//        }
    }
}
