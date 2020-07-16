package br.com.marcellogpassos.cnjapi.sgt.interessado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InteressadoJpaRepository extends JpaRepository<Interessado, Long> {

    Optional<Interessado> findFirstByEmail(String email);
}
