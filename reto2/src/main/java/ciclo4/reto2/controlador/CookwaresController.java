package ciclo4.reto2.controlador;

import ciclo4.reto2.modelo.Cookwares;
import ciclo4.reto2.servicio.CookwaresService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cookware")
@CrossOrigin("*")
public class CookwaresController {

    @Autowired
    private CookwaresService aService;

    @GetMapping("/all")
    public List<Cookwares> getAll(){
        return aService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cookwares> getItem(@PathVariable("reference") String reference){
        return aService.getItem(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookwares create(@RequestBody Cookwares g){
        return aService.create(g);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookwares update(@RequestBody Cookwares g){
        return aService.update(g);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return aService.delete(reference);
    }
    
}
