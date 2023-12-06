package com.emi.medicalimageprocessing.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "\"user\"")
public class User extends AbstractEntity {

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="fullname")
    private String fullName;

}
