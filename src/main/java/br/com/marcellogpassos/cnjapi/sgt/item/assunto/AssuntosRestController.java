package br.com.marcellogpassos.cnjapi.sgt.item.assunto;

import br.com.marcellogpassos.cnjapi.sgt.item.ItemRestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/assuntos", produces = MediaType.APPLICATION_JSON_VALUE)
public class AssuntosRestController extends ItemRestController {

    public AssuntosRestController(AssuntosService service) {
        super(service);
    }
}
