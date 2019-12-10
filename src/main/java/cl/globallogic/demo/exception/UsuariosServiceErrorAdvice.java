package cl.globallogic.demo.exception;

import cl.globallogic.demo.dto.UsuariosError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
@Slf4j
public class UsuariosServiceErrorAdvice extends ResponseEntityExceptionHandler {

   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   @ExceptionHandler({UsuariosServiceException.class,SQLException.class,NullPointerException.class,ConstraintViolationException.class,DataIntegrityViolationException.class})
   public ResponseEntity <UsuariosError> handleService() {
       UsuariosError response = new UsuariosError("correo ya utilizado");
       return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
   }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UsuariosValidationException.class})
    public void handle(UsuariosValidationException e) {}
}
