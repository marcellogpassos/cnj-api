package br.com.marcellogpassos.cnjapi.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorEntity {

    private String message;

    private String errorClass;

    private String stackTrace;

    private LocalDateTime thrownAt;
}
