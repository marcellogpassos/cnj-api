package br.com.marcellogpassos.cnjapi.sgt.item.assunto;

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
@Table(schema = "sgt_consulta", name = "assuntos")
public class Assunto {

    @Id
    @Column(name = "cod_assunto")
    @JsonIgnore
    private Long codigo;

    @Column(name = "sigiloso")
    @Convert(converter = SNConverter.class)
    private Boolean sigiloso;

    @Column(name = "assunto_secundario")
    @Convert(converter = SNConverter.class)
    private Boolean assuntoSecundario;

    @Column(name = "crime_antecedente")
    @Convert(converter = SNConverter.class)
    private Boolean crimeAntecedente;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dispositivoLegal", column = @Column(name = "dispositivo_legal")),
            @AttributeOverride(name = "artigo", column = @Column(name = "artigo")),
            @AttributeOverride(name = "glossario", column = @Column(name = "glossario"))
    })
    private DadosBasicosItem dadosBasicos;
}
