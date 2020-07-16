package br.com.marcellogpassos.cnjapi.sgt.item.tipo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TipoItemNaoEncontradoException extends RuntimeException {

    public TipoItemNaoEncontradoException() {
        super("Tipo de item não encontrado.");
    }
}
