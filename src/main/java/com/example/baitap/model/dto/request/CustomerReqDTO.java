package com.example.baitap.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerReqDTO implements Validator {

    private String fullName;

    private String email;

    private String phone;

    private String address;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomerReqDTO customerReqDTO = (CustomerReqDTO) o;

        String fullName = customerReqDTO.fullName;
        String email = customerReqDTO.email;
        String phone = customerReqDTO.phone;
        String address = customerReqDTO.address;

        if (StringUtils.isEmpty(fullName)) {
            errors.rejectValue("fullName", "fullName.null", "FullName không được để trống.");
        }
        if (StringUtils.isEmpty(email)) {
            errors.rejectValue("email", "email.null", "Email không được để trống.");
        }
        if (StringUtils.isEmpty(phone)) {
            errors.rejectValue("phone", "phone.null", "Phone không được để trống.");
        }
        if (StringUtils.isEmpty(address)) {
            errors.rejectValue("address", "address.null", "Address không được để trống.");
        }
    }
}
