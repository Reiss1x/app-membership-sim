package com.reis.cadastramento.core.model;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagamentoDTO {
    private LocalDate data;
    private Long codAssinatura;
    private Float valorPago;

}
