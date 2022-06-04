package br.com.gustosilva.springboottodoexternaldeploy.dominio.repositorio;

import br.com.gustosilva.springboottodoexternaldeploy.dominio.modelo.Etiqueta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
    Page<Etiqueta> findByNome(String nome, Pageable paginacao);
}
