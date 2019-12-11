package cl.globallogic.demo.exception;

import cl.globallogic.demo.dto.UsuariosError;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.management.BadAttributeValueExpException;


@ControllerAdvice
@Slf4j
public class UsuariosServiceErrorAdvice extends ResponseEntityExceptionHandler {

   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   @ExceptionHandler({UsuariosServiceException.class,
                    ConstraintViolationException.class})
   public ResponseEntity <UsuariosError> handleService() {
       UsuariosError response = new UsuariosError("correo ya utilizado");
       return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
   }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UsuariosValidationException.class,
            BadAttributeValueExpException.class})
    public ResponseEntity<UsuariosError> handleValidacion () {
       UsuariosError response = new UsuariosError("formato de email no corresponde");
       return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UsuariosNotFound.class,
            NullPointerException.class})
    public ResponseEntity<UsuariosError> handleValidacionPassword () {
        UsuariosError response = new UsuariosError("formato password no corresponde");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
