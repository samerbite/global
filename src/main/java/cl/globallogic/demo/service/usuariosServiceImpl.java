package cl.globallogic.demo.service;

import cl.globallogic.demo.model.usuarios;
import cl.globallogic.demo.repository.findUsuarios;
import cl.globallogic.demo.repository.usuariosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class usuariosServiceImpl {

    @Autowired
    usuariosRepository Repository;
    @Autowired
    findUsuarios RespositoryFind;

    public void crearUsuarios (usuarios request){
        usuarios existe = RespositoryFind.findByEmail(request.getEmail());
        log.info("el valor de buscar e-mail es:", existe);
        Repository.save(request);

    }
}
