package com.emi.medicalimageprocessing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public  class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //@CreatedDate
    @Column(name = "creationDate")
    private Instant creationDate;

    //@LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate;

    @PrePersist
    void prePersit(){
        creationDate = Instant.now();
    }

    @PreUpdate
    void preUpdate(){
        creationDate = Instant.now();
    }
}
