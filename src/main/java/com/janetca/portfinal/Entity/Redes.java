
package com.janetca.portfinal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Redes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String link;
    private String icono;
    
    public Redes(){
    }

    public Redes (String nombre, String link, String icono){
        this.nombre = nombre;
        this.link = link;
        this.icono = icono;
    }
    
}
