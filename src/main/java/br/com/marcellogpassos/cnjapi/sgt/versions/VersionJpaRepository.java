package br.com.marcellogpassos.cnjapi.sgt.versions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VersionJpaRepository extends JpaRepository<Version, Long> {

    Optional<Version> findFirstByOrderByDataVersaoDesc();

    Optional<Version> findFirstByAtualizadaTrueOrderByDataVersaoDesc();
}
