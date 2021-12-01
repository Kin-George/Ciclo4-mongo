package ciclo4.reto2.repositorio;

import ciclo4.reto2.modelo.Cookwares;
import ciclo4.reto2.interfaces.InterfaceCookwares;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CookwaresRepositorio {
    
    @Autowired
    private InterfaceCookwares repository;

    public List<Cookwares> getAll() {
        return repository.findAll();
    }

    public Optional<Cookwares> getItem(String reference){
        return repository.findById(reference);
    }

    public Cookwares create(Cookwares item){
        return repository.save(item);
    }

    public void update(Cookwares item){
        repository.save(item);
    }

    public void delete(Cookwares item){
        repository.delete(item);
    }
}
