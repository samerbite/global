package cl.globallogic.demo.controller;

import cl.globallogic.demo.model.usuarios;
import cl.globallogic.demo.service.usuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class usersController {
    @Autowired
    usuariosServiceImpl Usuarios;


    @PostMapping("/usuarios")
    public ResponseEntity<usuarios> createUser(@Valid @RequestBody usuarios request) {
        Usuarios.crearUsuarios(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

}
