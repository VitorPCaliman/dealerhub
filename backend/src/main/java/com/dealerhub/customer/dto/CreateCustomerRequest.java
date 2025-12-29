package com.dealerhub.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateCustomerRequest {

    @NotBlank
    public String fullName;

    @NotBlank
    @Email
    public String email;

    public String phone;
}
