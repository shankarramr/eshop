package com.gmail.shankar2k5.eshop.authservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Version {
    @Id
    @Column
    private String version;
}