
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
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int porcentaje;
    private String imgS;

    public Skills() {
    }

    public Skills(String nombre, int porcentaje, String imgS) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imgS = imgS;
    }

}
