package com.example.hello;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Hello extends PanacheEntity {
    public String message;
}

