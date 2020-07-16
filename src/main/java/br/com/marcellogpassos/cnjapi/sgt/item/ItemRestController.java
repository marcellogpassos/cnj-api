package br.com.marcellogpassos.cnjapi.sgt.item;

import br.com.marcellogpassos.cnjapi.sgt.item.commons.ItemDetalhadoTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@RequiredArgsConstructor
public class ItemRestController {

    protected final AbstractItemService service;

    @GetMapping
    public Collection<Item> findAll() {
        return this.service.findAll();
    }

    @GetMapping(params = {"primeiroNivel=true"})
    public Collection<Item> getRoots() {
        return this.service.getRoots();
    }

    @GetMapping(path = "/{codigo}")
    public Item findByCodigo(@PathVariable Long codigo) {
        return this.service.findByCodigo(codigo);
    }

    @GetMapping(path = "/{codigo}", params = "detalhado=true")
    public ItemDetalhadoTO<?> findByItem(@PathVariable Long codigo) {
        final var item = this.service.findByCodigo(codigo);
        return this.service.findByItem(item);
    }

    @GetMapping(path = "/{codigo}/filhos")
    public Collection<Item> getChildren(@PathVariable Long codigo) {
        Item itemPai = this.service.findByCodigo(codigo);
        return this.service.getChildren(itemPai);
    }

    @GetMapping(path = "/{codigo}/itemPai")
    public ResponseEntity<Item> getParent(@PathVariable Long codigo) {
        Item itemPai = this.service.findByCodigo(codigo);
        return this.service.getParent(itemPai)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping(path = "/{codigo}/ancestrais")
    public Collection<Item> getAncestrais(@PathVariable Long codigo) {
        Item element = this.service.findByCodigo(codigo);
        return this.service.getAncestors(element);
    }

    @GetMapping(path = "/{codigo}/descendentes")
    public Collection<Item> getDescendants(@PathVariable Long codigo) {
        Item root = this.service.findByCodigo(codigo);
        return this.service.getDescendants(root);
    }

    @GetMapping(path = "/{codigo}/tree")
    public ItemTreeNode getTree(@PathVariable Long codigo) {
        Item root = this.service.findByCodigo(codigo);
        return this.service.getTree(root);
    }
}
