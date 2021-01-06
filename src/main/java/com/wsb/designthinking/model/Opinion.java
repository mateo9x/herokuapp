package com.wsb.designthinking.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Pole nie moze byc puste")
    private String name;
    private Integer receipeNumber;
    private String postalCode;

    private String addedTime;
    @Email(message = "Nie prawidłowy email")
    private String email;
    @NotEmpty(message = "Pole nie moze byc puste")
    private String comment;
}
