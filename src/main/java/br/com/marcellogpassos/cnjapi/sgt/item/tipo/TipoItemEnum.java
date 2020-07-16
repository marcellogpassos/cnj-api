package br.com.marcellogpassos.cnjapi.sgt.item.tipo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoItemEnum {

    CLASSE("C", "Classe"),
    ASSUNTO("A", "Assunto"),
    MOVIMENTO("M", "Movimento");

    private final String codigo;
    private final String descricao;
}
