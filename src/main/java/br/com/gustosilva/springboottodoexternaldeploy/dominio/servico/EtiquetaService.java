package br.com.gustosilva.springboottodoexternaldeploy.dominio.servico;

import br.com.gustosilva.springboottodoexternaldeploy.api.dto.form.NovaEtiquetaForm;
import br.com.gustosilva.springboottodoexternaldeploy.api.dto.form.RemoverEtiquetaForm;
import br.com.gustosilva.springboottodoexternaldeploy.api.dto.form.RenomearEtiquetaForm;
import br.com.gustosilva.springboottodoexternaldeploy.dominio.modelo.Etiqueta;
import br.com.gustosilva.springboottodoexternaldeploy.dominio.repositorio.EtiquetaRepository;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public URI criar(NovaEtiquetaForm form) {
        Etiqueta etiqueta = etiquetaRepository.save(new Etiqueta(form.getNomeEtiqueta()));
        return URI.create("/etiquetas/" + etiqueta.getId());
    }

    public Page<Etiqueta> buscar(String nomeEtiqueta, Pageable paginacao) {
        return nomeEtiqueta == null
                ? etiquetaRepository.findAll(paginacao)
                : etiquetaRepository.findByNome(nomeEtiqueta, paginacao);
    }

    public void renomear(RenomearEtiquetaForm form) {
        Etiqueta etiqueta = etiquetaRepository.findById(form.getIdEtiqueta())
                .orElseThrow(() -> new RuntimeException("Erro ao procurar a etiqueta"));
        etiquetaRepository.save(etiqueta);
    }

    public void remover(RemoverEtiquetaForm form) {
        Etiqueta etiqueta = etiquetaRepository.findById(form.getIdEtiqueta())
                .orElseThrow(() -> new RuntimeException("Erro ao procurar a etiqueta"));
        etiquetaRepository.delete(etiqueta);
    }
}
