package br.com.marcellogpassos.cnjapi.sgt.item.movimento;

import br.com.marcellogpassos.cnjapi.sgt.item.commons.DadosBasicosItem;
import br.com.marcellogpassos.cnjapi.sgt.item.commons.SNConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "sgt_consulta", name = "movimentos")
public class Movimento {

    @Id
    @Column(name = "cod_movimento")
    @JsonIgnore
    private Long codigo;

    @Column(name = "movimento")
    private String descricaoMovimento;

    @Column(name = "visibilidade_externa")
    @Convert(converter = SNConverter.class)
    private Boolean visibilidadeExterna;

    @Column(name = "monocratico")
    @Convert(converter = SNConverter.class)
    private Boolean monocratico;

    @Column(name = "colegiado")
    @Convert(converter = SNConverter.class)
    private Boolean colegiado;

    @Column(name = "presidente_vice")
    @Convert(converter = SNConverter.class)
    private Boolean presidenteVice;

    @Column(name = "flg_papel")
    @Convert(converter = SNConverter.class)
    private Boolean papel;

    @Column(name = "flg_eletronico")
    @Convert(converter = SNConverter.class)
    private Boolean eletronico;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dispositivoLegal", column = @Column(name = "dispositivo_legal")),
            @AttributeOverride(name = "artigo", column = @Column(name = "artigo")),
            @AttributeOverride(name = "glossario", column = @Column(name = "glossario"))
    })
    private DadosBasicosItem dadosBasicos;
}
