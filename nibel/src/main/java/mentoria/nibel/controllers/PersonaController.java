package mentoria.nibel.controllers;


import mentoria.nibel.models.Persona;
import mentoria.nibel.repository.Probando;
import mentoria.nibel.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private Repository repo;

    Probando probando;

    @GetMapping("/personas")
    public List<Persona> listarPersonas(){
        return repo.findAll();
    }

    @PostMapping("/agregar")
    public String agregarPersona(@RequestBody Persona persona){
        repo.save(persona);
        return "Persona adicionada";
    }

    @PutMapping("/editar/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona ){
        Persona updatePersona = repo.findById(id).get();
        updatePersona.setNombre(persona.getNombre());
        updatePersona.setTelefono(persona.getTelefono());
        repo.save(updatePersona);
        return "Editado Correctamente";
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id){
        Persona deletePersona = repo.findById(id).get();
        repo.delete(deletePersona);
        return "Eliminado Correctamente";
    }


}
