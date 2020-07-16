package br.com.marcellogpassos.cnjapi.sgt.item.movimento;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MovimentoJpaRepositoryTest {

    @Autowired
    private MovimentoJpaRepository repository;

    @Test
    void validate() {
        final var found = this.repository.findById(51L);
        assertNotNull(found);
    }
}
