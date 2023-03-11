
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
public class Proyecto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    private String nombreP;
    private String descripcionP;
    private String linkP;

    private String fechaP;

    private String imgP;

    public Proyecto() {
    }

    public Proyecto(String nombreP, String descripcionP, String linkP, String fechaP, String imgP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.linkP = linkP;
        this.fechaP = fechaP;
        this.imgP = imgP;
    }

}
