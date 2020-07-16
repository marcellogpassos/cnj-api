package br.com.marcellogpassos.cnjapi.sgt.mirror;

import br.jus.tjpb.libs.sgtsoapcient.SgtSoapClient;
import br.jus.tjpb.libs.sgtsoapcient.getarrayfilhositem.ArvoreGenerica;
import br.jus.tjpb.libs.sgtsoapcient.getcomplementomovimento.ComplementoMovimento;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.ItemSgt;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.TipoItemEnum;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.TipoPesquisaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/mirror", produces = MediaType.APPLICATION_JSON_VALUE)
public class MirrorRestController {

    private final SgtSoapClient sgtSoapClient;

    @GetMapping("/getArrayDetalhesItem")
    public Map<String, String> getArrayDetalhesItem(Long seqItem, TipoItemEnum tipoItem) {
        return this.sgtSoapClient.getArrayDetalhesItem(seqItem, tipoItem);
    }

    @GetMapping("/getArrayFilhosItem")
    public Collection<ArvoreGenerica> getArrayFilhosItem(Long seqItem, TipoItemEnum tipoItem) {
        return this.sgtSoapClient.getArrayFilhosItem(seqItem, tipoItem);
    }

    @GetMapping("/getComplementoMovimento")
    public Collection<ComplementoMovimento> getComplementoMovimento(Long codMovimento) {
        return this.sgtSoapClient.getComplementoMovimento(codMovimento);
    }

    @GetMapping("/getDataUltimaVersao")
    public LocalDate getDataUltimaVersao() {
        return this.sgtSoapClient.getDataUltimaVersao();
    }

    @GetMapping("/getStringPaisItem")
    public Collection<String> getStringPaisItem(Long seqItem, TipoItemEnum tipoItem) {
        return this.sgtSoapClient.getStringPaisItem(seqItem, tipoItem);
    }

    @GetMapping("/pesquisarItem")
    public Collection<ItemSgt> pesquisarItem(TipoItemEnum tipoItem, TipoPesquisaEnum tipoPesquisa, String valorPesquisa) {
        return this.sgtSoapClient.pesquisarItem(tipoItem, tipoPesquisa, valorPesquisa);
    }
}
