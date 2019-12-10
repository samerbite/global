package cl.globallogic.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuariosValidationException extends RuntimeException{
    public UsuariosValidationException(String message) {

        super(message);
    }
}
