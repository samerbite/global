package cl.globallogic.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuariosNotFound extends NullPointerException {
    public UsuariosNotFound(String exception) {
        super(exception);
    }
}
