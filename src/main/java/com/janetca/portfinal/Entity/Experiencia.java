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
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String puestoE;
    private String fechaI;
    private String fechaT;

    private String imgE;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String puestoE, String fechaI, String fechaT, String imgE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.puestoE = puestoE;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.imgE = imgE;
    }

}
