package com.stripclub.appointment.request;

import com.stripclub.appointment.api.dto.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserRequest {
    private UserRequest() {

    }

    private static final String userService = "http://user:8082";

    public  static User getUserById(long idUser) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<Long> userRequest = new HttpEntity<>(idUser);
        final ResponseEntity<User> UserInfo = restTemplate.exchange(
                userService + "/users/" + idUser, HttpMethod.GET, userRequest, User.class);
        return UserInfo.getBody();
    }
}
