package br.com.marcellogpassos.cnjapi.sgt.item.movimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoJpaRepository extends JpaRepository<Movimento, Long> {
}
