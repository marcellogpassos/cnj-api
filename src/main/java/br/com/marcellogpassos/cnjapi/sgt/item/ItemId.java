package br.com.marcellogpassos.cnjapi.sgt.item;

import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemEnum;
import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemEnumConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.io.Serializable;

@Data
public class ItemId implements Serializable {

    @Column(name = "cod_item")
    private Long codigo;

    @Column(name = "tipo_item")
    @Convert(converter = TipoItemEnumConverter.class)
    private TipoItemEnum tipo;
}
