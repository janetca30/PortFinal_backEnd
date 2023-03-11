
package com.janetca.portfinal.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoRedes {
    @NotBlank
    private String nombre;
    @NotBlank
    private String link;
    private String icono;
    
    public dtoRedes(){
    }

    public dtoRedes (String nombre, String link, String icono){
        this.nombre = nombre;
        this.link = link;
        this.icono = icono;
    }
}
