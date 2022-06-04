package br.com.gustosilva.springboottodoexternaldeploy.api.dto.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RenomearEtiquetaForm {
    private Long idEtiqueta;
    private String nomeEtiqueta;
}
