
package com.janetca.portfinal.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoSkills {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    private String imgS;
    
    public dtoSkills() {
    }

    public dtoSkills(String nombre, int porcentaje, String imgS) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imgS = imgS;
    }

}
