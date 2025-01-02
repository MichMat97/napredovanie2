package com.vaii.napredovanie2.service;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoForPasswd {
    private Long id;

    @NotEmpty(message = "Email musi byt vyplneny")
    @Email
    private String email;

    @NotEmpty(message = "Heslo musi byt vyplnene")
    private String password;


}