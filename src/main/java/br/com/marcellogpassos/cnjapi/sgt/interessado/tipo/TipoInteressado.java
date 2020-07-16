package br.com.marcellogpassos.cnjapi.sgt.interessado.tipo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "public", name = "tb_tipo_interessado")
public class TipoInteressado {

    @Id
    @Column(name = "id_tipo_interessado")
    private Long id;

    @Column(name = "ds_tipo_interessado")
    private String descricao;
}
