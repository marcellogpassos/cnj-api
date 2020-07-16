package br.com.marcellogpassos.cnjapi.sgt.versions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "public", name = "tb_version")
@SequenceGenerator(name = "version_sq_gen", sequenceName = "tb_version_id_version_seq", allocationSize = 1)
public class Version {

    @Id
    @Column(name = "id_version")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "version_sq_gen")
    private Long id;

    @Column(name = "dt_data_versao")
    private LocalDate dataVersao;

    @Column(name = "fl_versao_atualizada")
    private Boolean atualizada;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Version(LocalDate dataVersao) {
        this.dataVersao = dataVersao;
        this.atualizada = false;
    }
}
