package br.com.marcellogpassos.cnjapi.sgt.item;

import lombok.Data;

import java.util.Collection;

@Data
public class ItemTreeNode {

    private Item item;

    private Collection<ItemTreeNode> children;

    public ItemTreeNode(Item item) {
        this.item = item;
    }

    public ItemTreeNode(Item item, Collection<ItemTreeNode> children) {
        this.item = item;
        this.children = children;
    }
}
