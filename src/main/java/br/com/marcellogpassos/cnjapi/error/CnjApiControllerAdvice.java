package br.com.marcellogpassos.cnjapi.error;

import br.com.marcellogpassos.cnjapi.sgt.item.ItemNaoEncontradoException;
import br.com.marcellogpassos.cnjapi.sgt.item.situacao.SituacaoItemNaoEncontradoException;
import br.com.marcellogpassos.cnjapi.sgt.item.tipo.TipoItemNaoEncontradoException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CnjApiControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            ItemNaoEncontradoException.class,
            SituacaoItemNaoEncontradoException.class,
            TipoItemNaoEncontradoException.class
    })
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        final var errorEntity = new ErrorEntity(ex.getMessage(), ex.getClass().getCanonicalName(),
                ExceptionUtils.getStackTrace(ex), LocalDateTime.now());
        return handleExceptionInternal(ex, errorEntity, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleDefault(Exception ex, WebRequest request) {
        final var errorEntity = new ErrorEntity(ex.getMessage(), ex.getClass().getCanonicalName(),
                ExceptionUtils.getStackTrace(ex), LocalDateTime.now());
        return handleExceptionInternal(ex, errorEntity, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
