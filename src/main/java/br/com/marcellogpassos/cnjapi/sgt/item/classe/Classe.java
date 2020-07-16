package br.com.marcellogpassos.cnjapi.sgt.item.classe;

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
@Table(schema = "sgt_consulta", name = "classes")
public class Classe {

    @Id
    @Column(name = "cod_classe")
    @JsonIgnore
    private Long codigo;

    @Column(name = "natureza")
    private String natureza;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "sigla_antiga")
    private String siglaAntiga;

    @Column(name = "polo_ativo")
    private String poloAtivo;

    @Column(name = "polo_passivo")
    private String poloPassivo;

    @Column(name = "numeracao_propria")
    @Convert(converter = SNConverter.class)
    private Boolean numeracaoPropria;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dispositivoLegal", column = @Column(name = "dispositivo_legal")),
            @AttributeOverride(name = "artigo", column = @Column(name = "artigo")),
            @AttributeOverride(name = "glossario", column = @Column(name = "glossario"))
    })
    private DadosBasicosItem dadosBasicos;
}
