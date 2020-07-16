package br.com.marcellogpassos.cnjapi.sgt.item.movimento;

import br.com.marcellogpassos.cnjapi.sgt.item.AbstractItemService;
import br.com.marcellogpassos.cnjapi.sgt.item.Item;
import br.com.marcellogpassos.cnjapi.sgt.item.ItemJpaRepository;
import br.com.marcellogpassos.cnjapi.sgt.item.ItemNaoEncontradoException;
import br.com.marcellogpassos.cnjapi.sgt.item.commons.ItemDetalhadoTO;
import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemEnum;
import org.springframework.stereotype.Service;

@Service
public class MovimentosService extends AbstractItemService {

    private final MovimentoJpaRepository movimentoRepository;

    public MovimentosService(ItemJpaRepository repository, MovimentoJpaRepository movimentoRepository) {
        super(repository);
        this.movimentoRepository = movimentoRepository;
    }

    @Override
    protected TipoItemEnum getTipo() {
        return TipoItemEnum.MOVIMENTO;
    }

    @Override
    public ItemDetalhadoTO<Movimento> findByItem(Item item) {
        return new ItemDetalhadoTO<>(item, this.findById(item.getCodigo()));
    }

    public Movimento findById(Long id) {
        return this.movimentoRepository.findById(id).orElseThrow(ItemNaoEncontradoException::new);
    }
}
