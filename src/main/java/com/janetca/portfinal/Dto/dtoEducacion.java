
package com.janetca.portfinal.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoEducacion {
    @NotBlank
    private String tituloE;
    @NotBlank
    private String descripcionE;
    private String anioE;
    private String imgE;

    public dtoEducacion() {
    }

    public dtoEducacion(String tituloE, String descripcionE, String anioE, String imgE) {
        this.tituloE = tituloE;
        this.descripcionE = descripcionE;
        this.anioE = anioE;
        this.imgE = imgE;
    }

    
}
