package br.com.marcellogpassos.cnjapi.sgt.item.assunto;

import br.com.marcellogpassos.cnjapi.sgt.item.AbstractItemService;
import br.com.marcellogpassos.cnjapi.sgt.item.Item;
import br.com.marcellogpassos.cnjapi.sgt.item.ItemJpaRepository;
import br.com.marcellogpassos.cnjapi.sgt.item.ItemNaoEncontradoException;
import br.com.marcellogpassos.cnjapi.sgt.item.commons.ItemDetalhadoTO;
import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemEnum;
import org.springframework.stereotype.Service;

@Service
public class AssuntosService extends AbstractItemService {

    private final AssuntoJpaRepository assuntoRepository;

    public AssuntosService(ItemJpaRepository repository, AssuntoJpaRepository assuntoRepository) {
        super(repository);
        this.assuntoRepository = assuntoRepository;
    }

    @Override
    protected TipoItemEnum getTipo() {
        return TipoItemEnum.ASSUNTO;
    }

    @Override
    public ItemDetalhadoTO<Assunto> findByItem(Item item) {
        return new ItemDetalhadoTO<>(item, this.findById(item.getCodigo()));
    }

    public Assunto findById(Long id) {
        return this.assuntoRepository.findById(id).orElseThrow(ItemNaoEncontradoException::new);
    }
}
