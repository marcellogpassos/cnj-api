package br.com.marcellogpassos.cnjapi.config;

import br.jus.tjpb.libs.sgtsoapcient.SgtSoapClient;
import br.jus.tjpb.libs.sgtsoapcient.getarraydetalhesitem.GetArrayDetalhesItemService;
import br.jus.tjpb.libs.sgtsoapcient.getarrayfilhositem.GetArrayFilhosItemService;
import br.jus.tjpb.libs.sgtsoapcient.getcomplementomovimento.GetComplementoMovimentoService;
import br.jus.tjpb.libs.sgtsoapcient.getdataultimaversao.GetDataUltimaVersaoService;
import br.jus.tjpb.libs.sgtsoapcient.getstringpaisitem.GetStringPaisItemService;
import br.jus.tjpb.libs.sgtsoapcient.pesquisaritem.PesquisarItemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SgtSoapConfig {

    @Bean
    public SgtSoapClient getSgtSoapClient(@Value("${sgt-client.url}") String url,
                                          @Value("${sgt-client.enable_logging}") boolean enableLogging,
                                          @Value("${sgt-client.timeout}") int timeout) {
        return new SgtSoapClient(
                new GetArrayDetalhesItemService(url, enableLogging, timeout),
                new GetArrayFilhosItemService(url, enableLogging, timeout),
                new GetComplementoMovimentoService(url, enableLogging, timeout),
                new GetDataUltimaVersaoService(url, enableLogging, timeout),
                new GetStringPaisItemService(url, enableLogging, timeout),
                new PesquisarItemService(url, enableLogging, timeout));
    }
}
