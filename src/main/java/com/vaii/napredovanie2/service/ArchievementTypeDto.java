package com.vaii.napredovanie2.service;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArchievementTypeDto {

    private Long id;

    @NotEmpty
    private String name;

}