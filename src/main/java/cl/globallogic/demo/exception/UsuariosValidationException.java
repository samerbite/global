package cl.globallogic.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.management.BadAttributeValueExpException;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuariosValidationException extends BadAttributeValueExpException {
    public UsuariosValidationException(String message) {
        super(message);
    }
}
