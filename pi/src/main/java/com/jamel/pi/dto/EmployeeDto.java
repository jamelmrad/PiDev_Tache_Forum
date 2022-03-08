package com.jamel.pi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    public EmployeeDto(Long id ,String nom , String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
}
