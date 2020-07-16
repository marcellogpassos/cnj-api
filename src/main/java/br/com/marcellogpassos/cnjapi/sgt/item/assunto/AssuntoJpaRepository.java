package br.com.marcellogpassos.cnjapi.sgt.item.assunto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuntoJpaRepository extends JpaRepository<Assunto, Long> {
}
