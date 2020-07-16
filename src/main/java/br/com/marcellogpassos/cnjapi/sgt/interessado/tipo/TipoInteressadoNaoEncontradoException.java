package br.com.marcellogpassos.cnjapi.sgt.interessado.tipo;

public class TipoInteressadoNaoEncontradoException extends RuntimeException {

    public TipoInteressadoNaoEncontradoException() {
        super("Tipo de interessado não encontrado");
    }
}
