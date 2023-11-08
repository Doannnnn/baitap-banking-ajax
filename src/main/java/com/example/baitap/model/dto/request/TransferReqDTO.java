package com.example.baitap.model.dto.request;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TransferReqDTO implements Validator {
    private String senderId;

    private String recipientId;

    private String transferAmount;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        TransferReqDTO transferReqDTO = (TransferReqDTO) o;
        String transferAmount = transferReqDTO.transferAmount;


        if (transferAmount == null || transferAmount.isEmpty()) {
            errors.rejectValue("transferAmount", "transactionAmount.null", "Nhập số tiền cần chuyển.");
            return;
        }
        if (transferAmount.compareTo("10") < 0) {
            errors.rejectValue("transferAmount", "transactionAmount.min", "Số tiền phải lớn hớn hoặc bằng 10.");
            return;
        }
        if (transferAmount.compareTo("1000000000") > 0) {
            errors.rejectValue("transferAmount", "transactionAmount.max", "Số tiền phải lớn hớn hoặc bằng 10000000000.");
            return;
        }
//        if (transferAmount.compareTo(transfer.sender.getBalance()) > 0) {
//            errors.rejectValue("transferAmount", "transactionAmount.check", "Số dư không đủ.");
//            return;
//        }
    }
}
