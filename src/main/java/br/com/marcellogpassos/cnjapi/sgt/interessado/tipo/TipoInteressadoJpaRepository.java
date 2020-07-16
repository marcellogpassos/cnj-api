package br.com.marcellogpassos.cnjapi.sgt.interessado.tipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoInteressadoJpaRepository extends JpaRepository<TipoInteressado, Long> {

}
