package com.stripclub.appointment.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String firstname;
    private String lastname;
    private String phoneNumber;
}
