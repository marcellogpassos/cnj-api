package br.com.marcellogpassos.cnjapi.sgt.item;

import br.com.marcellogpassos.cnjapi.sgt.item.situacao.SituacaoItemEnum;
import br.com.marcellogpassos.cnjapi.sgt.item.situacao.SituacaoItemEnumConverter;
import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@IdClass(ItemId.class)
@Table(schema = "sgt_consulta", name = "itens")
public class Item {

    @Id
    private Long codigo;

    @Id
    private TipoItemEnum tipo;

    @Column(name = "nome")
    private String descricao;

    @Column(name = "situacao")
    @Convert(converter = SituacaoItemEnumConverter.class)
    private SituacaoItemEnum situacao;

    @Column(name = "cod_item_pai")
    private Long codigoItemPai;
}
