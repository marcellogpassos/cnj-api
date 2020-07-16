package br.com.marcellogpassos.cnjapi.sgt.item.tipo;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

@Component
public class TipoItemEnumConverter implements AttributeConverter<TipoItemEnum, String> {

    @Override
    public String convertToDatabaseColumn(TipoItemEnum entityAttribute) {
        return entityAttribute.getCodigo();
    }

    @Override
    public TipoItemEnum convertToEntityAttribute(String databaseColumn) {
        return Arrays.stream(TipoItemEnum.values())
                .filter(tipoItem -> databaseColumn.equals(tipoItem.getCodigo()))
                .findFirst()
                .orElseThrow(TipoItemNaoEncontradoException::new);
    }
}
