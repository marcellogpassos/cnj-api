package br.com.marcellogpassos.cnjapi.sgt.versions;

import br.jus.tjpb.libs.sgtsoapcient.SgtSoapClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Log4j2
@Service
@RequiredArgsConstructor
public class VersionUpdater {

    private final SgtSoapClient sgtSoapClient;
    private final VersionService versionService;

    @PostConstruct
    @Scheduled(cron = "0 0 12 * * *")
    public void run() {
        log.info(">>> Iniciando a verificação de atualização da versão do SGT.");

        try {
            final var dataUltimaVersao = this.sgtSoapClient.getDataUltimaVersao();
            log.info(">>> Data da última atualização: " + dataUltimaVersao.toString());

            if (!dataUltimaVersao.equals(this.versionService.getDataUltimaVersao())) {
                log.info(">>> Verificado o lançamento de uma nova versão.");
                this.versionService.registrarNovaVersao(dataUltimaVersao);
                log.info(">>> Nova versão registrada.");
            }
        } catch (Exception ex) {
            log.error(">>> Falha ao tentar atualizar a versão do SGT: " + ex.getMessage(), ex);
        }

        log.info(">>> Finalizada a verificação de atualização da versão do SGT.");
    }
}
