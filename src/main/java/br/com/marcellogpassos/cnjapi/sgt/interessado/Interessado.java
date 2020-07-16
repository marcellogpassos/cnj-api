package br.com.marcellogpassos.cnjapi.sgt.interessado;

import br.com.marcellogpassos.cnjapi.sgt.interessado.tipo.TipoInteressado;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "public", name = "tb_notification_list")
@SequenceGenerator(name = "notification_list_sq_gen", sequenceName = "tb_notification_list_id_notification_list_seq", allocationSize = 1)
public class Interessado {

    @Id
    @Column(name = "id_notification_list")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_list_sq_gen")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;

    @Column(name = "ds_email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_interessado")
    private TipoInteressado tipo;
}
