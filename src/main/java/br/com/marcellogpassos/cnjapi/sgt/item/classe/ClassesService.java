package br.com.marcellogpassos.cnjapi.sgt.item.classe;

import br.com.marcellogpassos.cnjapi.sgt.item.AbstractItemService;
import br.com.marcellogpassos.cnjapi.sgt.item.Item;
import br.com.marcellogpassos.cnjapi.sgt.item.ItemJpaRepository;
import br.com.marcellogpassos.cnjapi.sgt.item.ItemNaoEncontradoException;
import br.com.marcellogpassos.cnjapi.sgt.item.commons.ItemDetalhadoTO;
import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemEnum;
import org.springframework.stereotype.Service;

@Service
public class ClassesService extends AbstractItemService {

    private final ClasseJpaRepository classeRepository;

    public ClassesService(ItemJpaRepository repository, ClasseJpaRepository classeRepository) {
        super(repository);
        this.classeRepository = classeRepository;
    }

    @Override
    protected TipoItemEnum getTipo() {
        return TipoItemEnum.CLASSE;
    }

    @Override
    public ItemDetalhadoTO<Classe> findByItem(Item item) {
        return new ItemDetalhadoTO<>(item, this.findById(item.getCodigo()));
    }

    public Classe findById(Long id) {
        return this.classeRepository.findById(id).orElseThrow(ItemNaoEncontradoException::new);
    }
}
