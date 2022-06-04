package br.com.gustosilva.springboottodoexternaldeploy.dominio.repositorio;

import br.com.gustosilva.springboottodoexternaldeploy.dominio.modelo.Etiqueta;
import br.com.gustosilva.springboottodoexternaldeploy.dominio.modelo.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
