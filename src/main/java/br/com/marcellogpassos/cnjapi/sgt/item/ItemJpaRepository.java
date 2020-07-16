package br.com.marcellogpassos.cnjapi.sgt.item;

import br.com.marcellogpassos.cnjapi.sgt.item.situacao.SituacaoItemEnum;
import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item, ItemId> {

    Optional<Item> findFirstByCodigoAndTipoAndSituacao(Long codigo,
                                                       TipoItemEnum tipo,
                                                       SituacaoItemEnum situacao);

    Collection<Item> findByCodigoItemPaiAndTipoAndSituacao(Long codigoItemPai,
                                                           TipoItemEnum tipo,
                                                           SituacaoItemEnum situacao);

    Collection<Item> findByTipoAndSituacao(TipoItemEnum tipo,
                                           SituacaoItemEnum situacao);

    Collection<Item> findByTipoAndSituacaoAndCodigoItemPaiIsNull(TipoItemEnum tipo,
                                                                 SituacaoItemEnum situacao);
}
