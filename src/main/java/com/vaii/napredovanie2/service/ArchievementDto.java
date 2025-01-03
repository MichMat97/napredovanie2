package com.vaii.napredovanie2.service;

import com.vaii.napredovanie2.entity.AchievementType;
import com.vaii.napredovanie2.entity.CardClass;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArchievementDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private AchievementType type;

    private String description;

    @NotEmpty
    private String imgPath;

    @NotEmpty
    private CardClass cardClass;

}