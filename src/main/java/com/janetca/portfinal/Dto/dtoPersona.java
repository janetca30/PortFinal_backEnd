package com.janetca.portfinal.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoPersona {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String puesto;

    @NotBlank
    private String img;
    
    private String banner;
    
    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String descripcion, String puesto, String img, String banner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.puesto = puesto;
        this.img = img;
        this.banner = banner;
    }
}
