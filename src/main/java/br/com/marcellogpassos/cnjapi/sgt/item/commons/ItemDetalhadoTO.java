package br.com.marcellogpassos.cnjapi.sgt.item.commons;

import br.com.marcellogpassos.cnjapi.sgt.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDetalhadoTO<T> {
    public Item item;
    public T dadosDetalhados;
}
