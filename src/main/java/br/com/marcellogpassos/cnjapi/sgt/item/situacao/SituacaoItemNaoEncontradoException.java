package br.com.marcellogpassos.cnjapi.sgt.item.situacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SituacaoItemNaoEncontradoException extends RuntimeException {

    public SituacaoItemNaoEncontradoException() {
        super("Situação do item não encontrada.");
    }
}
