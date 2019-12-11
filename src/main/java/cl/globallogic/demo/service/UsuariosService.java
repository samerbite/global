package cl.globallogic.demo.service;

import cl.globallogic.demo.model.Usuarios;
import org.springframework.http.ResponseEntity;

import javax.management.BadAttributeValueExpException;

public interface UsuariosService {
    public ResponseEntity <Usuarios> crearUsuario (Usuarios request) throws BadAttributeValueExpException;
}
