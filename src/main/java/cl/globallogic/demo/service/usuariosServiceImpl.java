package cl.globallogic.demo.service;

import cl.globallogic.demo.model.usuarios;
import cl.globallogic.demo.repository.usuariosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class usuariosServiceImpl {

    @Autowired
    usuariosRepository Repository;

    public void crearUsuarios (usuarios request){
        Repository.save(request);

    }
}
