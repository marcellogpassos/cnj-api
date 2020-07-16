package br.com.marcellogpassos.cnjapi.sgt.interessado.tipo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoInteressadoService {

    private final TipoInteressadoJpaRepository repository;

    public TipoInteressado findById(Long id) {
        return this.repository.findById(id).orElseThrow(TipoInteressadoNaoEncontradoException::new);
    }

    public List<TipoInteressado> findAll() {
        return this.repository.findAll();
    }
}
