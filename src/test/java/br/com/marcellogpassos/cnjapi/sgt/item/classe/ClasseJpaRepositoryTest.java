package br.com.marcellogpassos.cnjapi.sgt.item.classe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClasseJpaRepositoryTest {

    @Autowired
    private ClasseJpaRepository repository;

    @Test
    void validate() {
        final var found = this.repository.findById(2L);
        assertNotNull(found);
    }
}
