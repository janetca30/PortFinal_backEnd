package com.janetca.portfinal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud ")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud ")
    private String apellido;
    
    @Column(length = 500)
    @NotNull
    private String descripcion;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud ")
    private String puesto;

    private String img;
    
    private String banner;
    
    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripcion, String puesto, String img, String banner){
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.puesto = puesto;
        this.img = img;
        this.banner = banner;
    }

}
