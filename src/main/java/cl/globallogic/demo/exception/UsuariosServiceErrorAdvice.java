package cl.globallogic.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;


@ControllerAdvice
public class UsuariosServiceErrorAdvice extends ResponseEntityExceptionHandler {
    /*@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UsuariosServiceException.class})

    public void handle(UsuariosNotFound e) {}*/

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({UsuariosServiceException.class, SQLException.class, NullPointerException.class})

    public void handle() {}

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UsuariosServiceException.class})

    public void handle(UsuariosValidationException e) {}*/

}
