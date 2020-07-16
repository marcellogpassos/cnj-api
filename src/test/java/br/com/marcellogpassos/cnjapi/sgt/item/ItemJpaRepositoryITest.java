package br.com.marcellogpassos.cnjapi.sgt.item;

import br.com.marcellogpassos.cnjapi.sgt.item.situacao.SituacaoItemEnum;
import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ItemJpaRepositoryITest {

    private final ItemJpaRepository repository;

    public ItemJpaRepositoryITest(@Autowired ItemJpaRepository repository) {
        this.repository = repository;
    }

    @Test
    public void findAll() {
        List<Item> all = this.repository.findAll();
        assertNotNull(all);
        assertFalse(all.isEmpty());
    }

    @ParameterizedTest
    @EnumSource(TipoItemEnum.class)
    void findFirstByCodigoAndTipoItemAndSituacao(TipoItemEnum tipo) {
        Long codigo = this.getCodigoItem(tipo);
        Optional<Item> oItem = this.repository
                .findFirstByCodigoAndTipoAndSituacao(codigo, tipo, SituacaoItemEnum.ATIVO);
        assertTrue(oItem.isPresent());
        assertEquals(codigo, oItem.get().getCodigo());
        assertEquals(tipo, oItem.get().getTipo());
        assertEquals(SituacaoItemEnum.ATIVO, oItem.get().getSituacao());
    }

    @ParameterizedTest
    @EnumSource(TipoItemEnum.class)
    void findByCodigoItemPaiAndTipoItemAndSituacao(TipoItemEnum tipo) {
        Long codigoItemPai = this.getCodigoItemPai(tipo);
        Collection<Item> found = this.repository
                .findByCodigoItemPaiAndTipoAndSituacao(codigoItemPai, tipo, SituacaoItemEnum.ATIVO);
        assertNotNull(found);
        assertFalse(found.isEmpty());
        assertTrue(found.stream()
                .allMatch(classe -> codigoItemPai.equals(classe.getCodigoItemPai()) &&
                        tipo.equals(classe.getTipo()) &&
                        SituacaoItemEnum.ATIVO.equals(classe.getSituacao())));
    }

    @ParameterizedTest
    @EnumSource(TipoItemEnum.class)
    void findByTipoAndSituacao(TipoItemEnum tipo) {
        Collection<Item> found = this.repository
                .findByTipoAndSituacao(tipo, SituacaoItemEnum.ATIVO);
        assertNotNull(found);
        assertFalse(found.isEmpty());
        assertTrue(found.stream()
                .allMatch(item -> tipo.equals(item.getTipo()) &&
                        SituacaoItemEnum.ATIVO.equals(item.getSituacao())));
    }

    @ParameterizedTest
    @EnumSource(TipoItemEnum.class)
    void findByTipoAndSituacaoAndCodigoItemPaiIsNull(TipoItemEnum tipo) {
        Collection<Item> found = this.repository
                .findByTipoAndSituacaoAndCodigoItemPaiIsNull(tipo, SituacaoItemEnum.ATIVO);
        assertNotNull(found);
        assertFalse(found.isEmpty());
        assertTrue(found.stream()
                .allMatch(item -> Objects.isNull(item.getCodigoItemPai()) &&
                        tipo.equals(item.getTipo()) &&
                        SituacaoItemEnum.ATIVO.equals(item.getSituacao())));
    }

    private Long getCodigoItem(TipoItemEnum tipo) {
        switch (tipo) {
            case CLASSE:
                return 7L;
            case ASSUNTO:
                return 7664L;
            case MOVIMENTO:
                return 51L;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private Long getCodigoItemPai(TipoItemEnum tipo) {
        switch (tipo) {
            case CLASSE:
                return 2L;
            case ASSUNTO:
                return 899L;
            case MOVIMENTO:
                return 1L;
            default:
                throw new UnsupportedOperationException();
        }
    }

}
