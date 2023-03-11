package com.janetca.portfinal.Controller;

import com.janetca.portfinal.Dto.dtoPersona;
import com.janetca.portfinal.Entity.Persona;
import com.janetca.portfinal.Security.Controller.Mensaje;
import com.janetca.portfinal.Service.ImpPersonaService;
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
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    ImpPersonaService personaService;
    /*@PreAuthorize("hasRole('ADMIN')")*/
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    /*@PreAuthorize("hasRole('ADMIN')")*/
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    /*@PreAuthorize("hasRole('ADMIN')")*/
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if (StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (personaService.existsByNombre(dtopersona.getNombre())) {            
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getApellido() 
                ,dtopersona.getDescripcion(), dtopersona.getPuesto(), dtopersona.getImg(), dtopersona.getBanner());        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona Agregada"), HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje ("El id no existe"),HttpStatus.BAD_REQUEST);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje ("La persona ha sido eliminada"),HttpStatus.OK);
        }

//URL:PUERTO/personas/editar.....
    /*@PreAuthorize("hasRole('ADMIN')")*/
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();

        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setPuesto(dtopersona.getPuesto());
        persona.setImg(dtopersona.getImg());
        persona.setBanner(dtopersona.getBanner());

        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
        }
    }
