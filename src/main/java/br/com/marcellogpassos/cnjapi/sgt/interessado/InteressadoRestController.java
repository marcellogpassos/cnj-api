package br.com.marcellogpassos.cnjapi.sgt.interessado;

import br.com.marcellogpassos.cnjapi.sgt.interessado.tipo.TipoInteressadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/public/interessados", produces = MediaType.APPLICATION_JSON_VALUE)
public class InteressadoRestController {

    private final InteressadoService service;
    private final TipoInteressadoService tipoInteressadoService;

    @PostMapping
    public Interessado save(@RequestBody @Valid InteressadoTO input) {
        final var tipoInteressado = this.tipoInteressadoService.findById(input.getIdTipoInteressado());
        return this.service.save(input.getNome(), input.getEmail(), tipoInteressado);
    }
}
