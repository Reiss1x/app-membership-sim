package com.reis.assinaturas_validas;

import java.time.LocalDate;

public record PagamentoDTO(LocalDate data, Long codAssinatura, Float valorPago) {
}