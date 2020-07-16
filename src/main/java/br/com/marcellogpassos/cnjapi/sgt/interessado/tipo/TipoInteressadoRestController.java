package br.com.marcellogpassos.cnjapi.sgt.interessado.tipo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/public/tipos-interessados", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoInteressadoRestController {

    private final TipoInteressadoService service;

    @GetMapping
    public List<TipoInteressado> findAll() {
        return this.service.findAll();
    }
}
