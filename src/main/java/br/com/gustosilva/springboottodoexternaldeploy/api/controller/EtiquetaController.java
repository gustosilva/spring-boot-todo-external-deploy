package br.com.gustosilva.springboottodoexternaldeploy.api.controller;

import br.com.gustosilva.springboottodoexternaldeploy.api.dto.form.NovaEtiquetaForm;
import br.com.gustosilva.springboottodoexternaldeploy.api.dto.form.RemoverEtiquetaForm;
import br.com.gustosilva.springboottodoexternaldeploy.api.dto.form.RenomearEtiquetaForm;
import br.com.gustosilva.springboottodoexternaldeploy.api.dto.view.EtiquetaView;
import br.com.gustosilva.springboottodoexternaldeploy.dominio.servico.EtiquetaService;
import javax.transaction.Transactional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etiqueta")
public class EtiquetaController {
    private final EtiquetaService etiquetaService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> criarEtiqueta(@RequestBody @Valid NovaEtiquetaForm form) {
        return ResponseEntity.created(etiquetaService.criar(form)).build();
    }

    @GetMapping
    public ResponseEntity<Page<EtiquetaView>> buscarEtiquetas(@RequestParam(required = false) String nomeEtiqueta,
                                                              Pageable paginacao) {
        return ResponseEntity.ok(etiquetaService.buscar(nomeEtiqueta, paginacao)
                .map(etiqueta -> new EtiquetaView(etiqueta.getId(), etiqueta.getNome())));
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<Void> renomearEtiqueta(@RequestBody @Valid RenomearEtiquetaForm form) {
        etiquetaService.renomear(form);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<Void> removerEtiqueta(@RequestBody @Valid RemoverEtiquetaForm form) {
        etiquetaService.remover(form);
        return ResponseEntity.noContent().build();
    }

}
