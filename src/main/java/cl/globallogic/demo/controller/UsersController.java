package cl.globallogic.demo.controller;

import cl.globallogic.demo.model.Usuarios;
import cl.globallogic.demo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UsersController {
    @Autowired
    UsuariosService Usuarios;


    @PostMapping("/usuarios")
    public ResponseEntity<Usuarios> createUser(@Valid @RequestBody Usuarios request) {
        Usuarios.crearUsuario(request);
        /*usuarios response = new usuarios();
        response.setId(request.getId());
        response.setCreacion(request.getCreacion());
        response.setModificado(request.getModificado());
        response.setActivo(request.getActivo());*/
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

}
