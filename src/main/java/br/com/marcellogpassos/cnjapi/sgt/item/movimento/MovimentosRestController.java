package br.com.marcellogpassos.cnjapi.sgt.item.movimento;

import br.com.marcellogpassos.cnjapi.sgt.item.ItemRestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/movimentos", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovimentosRestController extends ItemRestController {

    public MovimentosRestController(MovimentosService service) {
        super(service);
    }
}
