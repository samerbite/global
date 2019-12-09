package cl.globallogic.demo.service;

import cl.globallogic.demo.model.usuarios;
import cl.globallogic.demo.repository.findUsuarios;
import cl.globallogic.demo.repository.usuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class usuariosServiceImpl {

    @Autowired
    usuariosRepository Repository;
    @Autowired
    findUsuarios RespositoryFind;

    public void crearUsuarios (usuarios request){
        boolean existe = RespositoryFind.existsById(request.getId());
        if (existe == true) {
            //TODO setear error
        }else{
            Repository.save(request);
        }

    }
}
