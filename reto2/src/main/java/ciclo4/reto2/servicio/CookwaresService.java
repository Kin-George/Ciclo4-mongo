package ciclo4.reto2.servicio;

import ciclo4.reto2.modelo.Cookwares;
import ciclo4.reto2.repositorio.CookwaresRepositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookwaresService {

    @Autowired
    private CookwaresRepositorio itemRepository;

    public List<Cookwares> getAll(){
        return itemRepository.getAll();
    }

    public Optional<Cookwares> getItem(String reference){
        return itemRepository.getItem(reference);
    }

    public Cookwares create(Cookwares a){
        if (a.getReference() == null){
            return a;
        } else {
            return itemRepository.create(a);
        }
    }

    public Cookwares update(Cookwares a){

        if (a.getReference() != null){
            Optional<Cookwares> aDb = itemRepository.getItem(a.getReference());
            if (!aDb.isEmpty()){

                if (a.getBrand() != null){
                    aDb.get().setBrand(a.getBrand());
                }

                if (a.getCategory() != null){
                    aDb.get().setCategory(a.getCategory());
                }

                if (a.getMateriales() != null){
                    aDb.get().setMateriales(a.getMateriales());
                }

                if (a.getDimensiones() != null){
                    aDb.get().setDimensiones(a.getDimensiones());
                }

                if (a.getDescription() != null){
                    aDb.get().setDescription(a.getDescription());
                }

                if (a.getPrice() != 0.0){
                    aDb.get().setPrice(a.getPrice());
                }

                if (a.getQuantity() != 0){
                    aDb.get().setQuantity(a.getQuantity());
                }

                if (a.getPhotography() != null){
                    aDb.get().setPhotography(a.getPhotography());
                }
                aDb.get().setAvailability(a.isAvailability());
                itemRepository.update(aDb.get());
                return aDb.get();
            } else {
                return a;
            }
        } else {
            return a;
        }
    }

    public boolean delete(String reference){
        Boolean aBoolean = getItem(reference).map(a -> {
            itemRepository.delete(a);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
