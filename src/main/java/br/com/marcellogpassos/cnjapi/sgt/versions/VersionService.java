package br.com.marcellogpassos.cnjapi.sgt.versions;

import br.com.marcellogpassos.cnjapi.sendgrid.SendgridEmailSender;
import br.com.marcellogpassos.cnjapi.sgt.interessado.InteressadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VersionService {

    private final VersionJpaRepository repository;
    private final InteressadoService informedService;
    private final SendgridEmailSender emailSender;

    public List<Version> findAll() {
        return this.repository.findAll();
    }

    public LocalDate getDataUltimaVersao() {
        return this.repository.findFirstByOrderByDataVersaoDesc()
                .map(Version::getDataVersao)
                .orElse(null);
    }

    public Optional<LocalDate> getVersaoAtual() {
        return this.repository.findFirstByAtualizadaTrueOrderByDataVersaoDesc()
                .map(Version::getDataVersao);
    }

    public void registrarNovaVersao(LocalDate dataUltimaVersao) {
        final var novaVersao = this.repository.save(new Version(dataUltimaVersao));
        this.notificar(novaVersao);
    }

    private void notificar(Version novaVersao) {
        this.informedService.findAll().forEach(informed -> this.emailSender.notificar(informed, novaVersao));
    }
}
