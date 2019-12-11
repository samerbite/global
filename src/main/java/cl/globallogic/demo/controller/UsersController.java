package cl.globallogic.demo.controller;

import cl.globallogic.demo.dto.Response;
import cl.globallogic.demo.exception.UsuariosServiceException;
import cl.globallogic.demo.exception.UsuariosValidationException;
import cl.globallogic.demo.model.Usuarios;
import cl.globallogic.demo.service.LoginService;
import cl.globallogic.demo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.management.BadAttributeValueExpException;
import javax.validation.Valid;

@RestController
public class UsersController {
    @Autowired
    private UsuariosService Usuarios;

    @Autowired
    private LoginService Token;


    @PostMapping("/usuarios")
    public ResponseEntity<Usuarios> createUser(@Valid @RequestBody Usuarios request) throws BadAttributeValueExpException {
        try {
            String token = Token.obtenerToken(request.getName());
            request.setSerialVersionUID(token);
            request.setActivo("ACTIVO");
            Usuarios.crearUsuario(request);
            Response response = new Response();
            response.setId(request.getId());
            response.setCreacion(request.getCreacion());
            response.setModificado(request.getModificado());
            response.setLast_login(request.getCreacion());
            response.setToken(token);
            response.setIsactive("ACTIVO");
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (UsuariosServiceException exc){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (UsuariosValidationException exc){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
