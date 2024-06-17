package com.reis.cadastramento.core.model.requestnresponse;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class AssinaturaResponse {
    private Long cod;
    private Long codApp;
    private Long codCli;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private String status;
}
