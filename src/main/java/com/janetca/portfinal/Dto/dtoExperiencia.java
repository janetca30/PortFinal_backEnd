package com.janetca.portfinal.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoExperiencia {

    @NotBlank
    private String nombreE;
    private String descripcionE;
    private String puestoE;
    private String fechaI;
    private String fechaT;
    private String imgE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String puestoE, String fechaI, String fechaT, String imgE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.puestoE = puestoE;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.imgE = imgE;
    }

}
