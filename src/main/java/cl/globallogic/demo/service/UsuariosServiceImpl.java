package cl.globallogic.demo.service;

import cl.globallogic.demo.model.Usuarios;
import cl.globallogic.demo.repository.UsuariosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    UsuariosRepository Repository;

    @Override
    public Usuarios crearUsuario (Usuarios request){
        return Repository.save(request);

    }
}
