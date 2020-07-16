package br.com.marcellogpassos.cnjapi.sgt.item.commons;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class DadosBasicosItem {

    private String dispositivoLegal;

    private String artigo;

    private String glossario;
}
