
package com.janetca.portfinal.Controller;

import com.janetca.portfinal.Dto.dtoRedes;
import com.janetca.portfinal.Entity.Redes;
import com.janetca.portfinal.Security.Controller.Mensaje;
import com.janetca.portfinal.Service.SRedes;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfinal-5ec3b.web.app")
@RequestMapping("/redes")
public class CRedes {
    @Autowired
    SRedes sRedes;

    @GetMapping("/lista")
    public ResponseEntity<List<Redes>> list() {
        List<Redes> list = sRedes.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Redes> getById(@PathVariable("id") int id) {
        if (!sRedes.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Redes redes = sRedes.getOne(id).get();
        return new ResponseEntity(redes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sRedes.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sRedes.delete(id);
        return new ResponseEntity(new Mensaje("Red social eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoRedes dtoredes) {
        if (StringUtils.isBlank(dtoredes.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sRedes.existsByNombre(dtoredes.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa red social ya existe"), HttpStatus.BAD_REQUEST);
        }

        Redes redes = new Redes(dtoredes.getNombre(), dtoredes.getLink(), dtoredes.getIcono());
        sRedes.save(redes);

        return new ResponseEntity(new Mensaje("Red social agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoRedes dtoredes) {
        //Validamos si existe el ID
        if (!sRedes.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de red
        if (sRedes.existsByNombre(dtoredes.getNombre()) && sRedes.getByNombre(dtoredes.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa red social ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoredes.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Redes redes = sRedes.getOne(id).get();
        redes.setNombre(dtoredes.getNombre());
        redes.setLink(dtoredes.getLink());
        redes.setIcono(dtoredes.getIcono());

        sRedes.save(redes);
        return new ResponseEntity(new Mensaje("Red Social actualizada"), HttpStatus.OK);

    }
}