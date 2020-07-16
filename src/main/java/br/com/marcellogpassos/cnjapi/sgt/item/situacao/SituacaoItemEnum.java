package br.com.marcellogpassos.cnjapi.sgt.item.situacao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SituacaoItemEnum {

    ATIVO("A"),
    INATIVO("I");

    private final String codigo;
}
