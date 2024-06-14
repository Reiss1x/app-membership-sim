package com.reis.cadastramento.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Assinatura {
    @Id
    private Long cod;
    private Long codApp;
    private Long codCli;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
}
