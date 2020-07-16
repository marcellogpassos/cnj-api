package br.com.marcellogpassos.cnjapi.sgt.item.situacao;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

@Component
public class SituacaoItemEnumConverter implements AttributeConverter<SituacaoItemEnum, String> {

    @Override
    public String convertToDatabaseColumn(SituacaoItemEnum entityAttribute) {
        return entityAttribute.getCodigo();
    }

    @Override
    public SituacaoItemEnum convertToEntityAttribute(String databaseColumn) {
        return Arrays.stream(SituacaoItemEnum.values())
                .filter(situacaoItem -> databaseColumn.equals(situacaoItem.getCodigo()))
                .findFirst()
                .orElseThrow(SituacaoItemNaoEncontradoException::new);
    }
}
