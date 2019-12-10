package cl.globallogic.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UsuariosServiceException extends  RuntimeException{
    public UsuariosServiceException(String message) {
        super(message);
    }
}
