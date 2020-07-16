package br.com.marcellogpassos.cnjapi.sgt.item.classe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseJpaRepository extends JpaRepository<Classe, Long> {
}
