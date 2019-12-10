package cl.globallogic.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


@ControllerAdvice
@Slf4j
public class UsuariosServiceErrorAdvice {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({UsuariosServiceException.class,
            SQLException.class,
            NullPointerException.class,
            DataIntegrityViolationException.class})
    public void handle() {}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UsuariosValidationException.class})
    public void handle(UsuariosValidationException e) {}
}
