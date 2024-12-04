package com.vaii.napredovanie2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="achievements")
public class Achievement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AchievementType type;

    @Column(length = 500)
    private String description;

    @Column(nullable=false)
    private String imgPath;

}