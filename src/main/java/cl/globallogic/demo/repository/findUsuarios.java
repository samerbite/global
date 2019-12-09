package cl.globallogic.demo.repository;

import cl.globallogic.demo.model.usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface findUsuarios extends CrudRepository<usuarios, Long> {
    
    //boolean existByEmail(String email);
    //Optional<usuarios> findByEemail(String email);
}
