package com.reis.cadastramento.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aplicativo {
    @Id
    private Long cod;
    private String nome;
    private Float custoMensal;
}
