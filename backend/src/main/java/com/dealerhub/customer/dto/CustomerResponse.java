package com.dealerhub.customer.dto;

import java.time.Instant;
import java.util.UUID;

public class CustomerResponse {

    public UUID id;
    public String fullName;
    public String email;
    public String phone;
    public Instant createdAt;
}
