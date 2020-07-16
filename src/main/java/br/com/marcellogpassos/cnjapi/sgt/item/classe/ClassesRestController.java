package br.com.marcellogpassos.cnjapi.sgt.item.classe;

import br.com.marcellogpassos.cnjapi.sgt.item.ItemRestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/classes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClassesRestController extends ItemRestController {

    public ClassesRestController(ClassesService service) {
        super(service);
    }
}
