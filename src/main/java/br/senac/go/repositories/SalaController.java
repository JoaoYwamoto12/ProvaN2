package br.senac.go.repositories;

import br.senac.go.domain.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/salas")
public class SalaController {

    @Autowired
    private SalaRepository repository;


    @GetMapping
    public List<Sala> findAll(){
        List<Sala> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Sala findById(@PathVariable Long id){
        Sala result = repository.findById((long) Math.toIntExact(id)).get();
        return result;
    }

    @PostMapping
    public Sala insert(@RequestBody Sala sala){
        Sala result = repository.save(sala);
        return result;
    }


}
