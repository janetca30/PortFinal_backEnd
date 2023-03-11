package com.janetca.portfinal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloE;
    private String descripcionE;
    private String anioE;
    private String imgE;

    public Educacion() {
    }

    public Educacion(String tituloE, String descripcionE, String anioE, String imgE) {
        this.tituloE = tituloE;
        this.descripcionE = descripcionE;
        this.anioE = anioE;
        this.imgE = imgE;
    }

}
