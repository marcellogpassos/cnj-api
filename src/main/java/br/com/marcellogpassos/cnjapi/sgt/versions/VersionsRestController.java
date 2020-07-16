package br.com.marcellogpassos.cnjapi.sgt.versions;

import br.jus.tjpb.libs.sgtsoapcient.SgtSoapClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/public/versoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class VersionsRestController {

    private final SgtSoapClient sgtSoapClient;
    private final VersionService service;

    @GetMapping
    public List<Version> all() {
        return this.service.findAll();
    }

    @GetMapping("/ultima")
    public LocalDate last() {
        return this.sgtSoapClient.getDataUltimaVersao();
    }

    @GetMapping("/atual")
    public ResponseEntity<LocalDate> current() {
        return this.service.getVersaoAtual()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
