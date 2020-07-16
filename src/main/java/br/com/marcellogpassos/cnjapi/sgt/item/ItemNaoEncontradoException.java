package br.com.marcellogpassos.cnjapi.sgt.item;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNaoEncontradoException extends RuntimeException {

    public ItemNaoEncontradoException() {
        super("Item não encontrado.");
    }
}
