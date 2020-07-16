package br.com.marcellogpassos.cnjapi.sgt.item.commons;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import java.util.Objects;

@Component
public class SNConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean entityAttribute) {
        if (Objects.isNull(entityAttribute)) {
            return null;
        } else {
            return entityAttribute ? "S" : "N";
        }
    }

    @Override
    public Boolean convertToEntityAttribute(String databaseColumn) {
        if (Objects.isNull(databaseColumn)) {
            return null;
        } else if (databaseColumn.trim().equalsIgnoreCase("S")) {
            return true;
        } else if (databaseColumn.trim().equalsIgnoreCase("N")) {
            return false;
        } else {
            return null;
        }
    }
}
