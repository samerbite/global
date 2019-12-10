package cl.globallogic.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuariosNotFound {
    public UsuariosNotFound(String exception) {
        super();
    }
}
