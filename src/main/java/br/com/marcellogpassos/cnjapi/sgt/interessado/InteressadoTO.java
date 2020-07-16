package br.com.marcellogpassos.cnjapi.sgt.interessado;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class InteressadoTO {

    @NotNull
    private String nome;

    @NotNull
    @Email
    private String email;

    @NotNull
    private Long idTipoInteressado;
}
