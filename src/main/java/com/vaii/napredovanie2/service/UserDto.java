package com.vaii.napredovanie2.service;

import com.vaii.napredovanie2.entity.Role;
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
public class UserDto {
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty(message = "Email musi byt vyplneny")
    @Email
    private String email;

    @NotEmpty(message = "Heslo musi byt vyplnene")
    private String password;


    private Role role;
}