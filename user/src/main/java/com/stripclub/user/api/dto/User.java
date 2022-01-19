package com.stripclub.user.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class User {
        private String firstname;
        private String lastname;
        private String email;
        private String login;
        private String password;
        private String phoneNumber;
        }