package com.reis.pagamentos.core.model;
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
