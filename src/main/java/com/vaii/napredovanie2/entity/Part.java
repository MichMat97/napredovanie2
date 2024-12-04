//package com.vaii.napredovanie2.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "parts")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Part {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable=false)
//    private String name;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinTable(
//            name="archieved",
//            joinColumns={@JoinColumn(name="PART_ID", referencedColumnName="ID")},
//            inverseJoinColumns={@JoinColumn(name="ARCHIEVMENTTYPE_ID", referencedColumnName="ID")})
//    private List<Role> roles = new ArrayList<>();
//
//}
