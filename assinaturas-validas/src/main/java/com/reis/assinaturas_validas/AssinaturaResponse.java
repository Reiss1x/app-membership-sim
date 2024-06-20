package com.reis.assinaturas_validas;

import java.time.LocalDate;

public record AssinaturaResponse(Long cod, Long codApp, Long codCli, LocalDate inicioVigencia, LocalDate fimVigencia, String status) {
}
