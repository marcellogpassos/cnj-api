package br.com.marcellogpassos.cnjapi.sgt.interessado;

import br.com.marcellogpassos.cnjapi.sgt.interessado.tipo.TipoInteressado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteressadoService {

    private final InteressadoJpaRepository repository;

    public List<Interessado> findAll() {
        return this.repository.findAll();
    }

    public Interessado save(String nome, String email, TipoInteressado tipoInteressado) {
        final var entry = this.repository.findFirstByEmail(email).orElse(new Interessado());
        entry.setNome(nome);
        entry.setEmail(email);
        entry.setTipo(tipoInteressado);
        return this.repository.save(entry);
    }
}
