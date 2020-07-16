package br.com.marcellogpassos.cnjapi.sgt.item;

import br.com.marcellogpassos.cnjapi.sgt.item.commons.ItemDetalhadoTO;
import br.com.marcellogpassos.cnjapi.sgt.item.situacao.SituacaoItemEnum;
import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public abstract class AbstractItemService {

    private final ItemJpaRepository repository;

    protected abstract TipoItemEnum getTipo();

    public abstract ItemDetalhadoTO<?> findByItem(Item item);

    public Item findByCodigo(Long codigo) {
        return this.getItem(codigo, this.getTipo());
    }

    public Collection<Item> findAll() {
        return this.findAll(this.getTipo());
    }

    public Collection<Item> findAll(TipoItemEnum tipo) {
        return this.repository.findByTipoAndSituacao(tipo, SituacaoItemEnum.ATIVO);
    }

    public Collection<Item> getRoots() {
        return this.getRoots(this.getTipo());
    }

    public Collection<Item> getAncestors(Item element) {
        return this.getParent(element)
                .map(this::getAncestorsByParent)
                .orElse(Collections.emptySet());
    }

    private Collection<Item> getAncestorsByParent(Item parent) {
        return Stream.concat(Stream.of(parent), this.getAncestors(parent).stream())
                .collect(Collectors.toSet());
    }

    public Collection<Item> getChildren(Item itemPai) {
        return this.repository.findByCodigoItemPaiAndTipoAndSituacao(itemPai.getCodigo(), itemPai.getTipo(),
                SituacaoItemEnum.ATIVO);
    }

    public Collection<Item> getDescendants(Item item) {
        final Collection<Item> children = this.getChildren(item);
        return children.isEmpty() ? Collections.emptySet() : Stream.concat(children.stream(), children.stream()
                .map(this::getDescendants)
                .flatMap(Collection::stream))
                .collect(Collectors.toSet());
    }

    public Item getItem(Long codigo, TipoItemEnum tipo) {
        return this.repository.findFirstByCodigoAndTipoAndSituacao(codigo, tipo, SituacaoItemEnum.ATIVO)
                .orElseThrow(ItemNaoEncontradoException::new);
    }

    public Optional<Item> getParent(Item item) {
        return Optional.ofNullable(item.getCodigoItemPai())
                .map(codigoItemPai -> this.getItem(codigoItemPai, item.getTipo()));
    }

    public Collection<Item> getRoots(TipoItemEnum tipo) {
        return this.repository.findByTipoAndSituacaoAndCodigoItemPaiIsNull(tipo, SituacaoItemEnum.ATIVO);
    }

    public ItemTreeNode getTree(Item root) {
        final Collection<Item> children = this.getChildren(root);
        return children.isEmpty() ? new ItemTreeNode(root) : new ItemTreeNode(root, children.stream()
                .map(this::getTree)
                .collect(Collectors.toSet()));
    }
}
