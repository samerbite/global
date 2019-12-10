package cl.globallogic.demo.controller;

import cl.globallogic.demo.exception.UsuariosServiceErrorAdvice;
import cl.globallogic.demo.exception.UsuariosServiceException;
import cl.globallogic.demo.model.Usuarios;
import cl.globallogic.demo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
public class UsersController {
    @Autowired
    UsuariosService Usuarios;


    @PostMapping("/usuarios")
    public ResponseEntity<Usuarios> createUser(@Valid @RequestBody Usuarios request) {
        try {
            Usuarios.crearUsuario(request);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }catch (UsuariosServiceException exc){
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
