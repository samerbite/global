package cl.globallogic.demo.service;

import cl.globallogic.demo.exception.UsuariosServiceException;
import cl.globallogic.demo.model.Usuarios;
import cl.globallogic.demo.repository.UsuariosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuariosRepository Repository;

    @Override
    public ResponseEntity <Usuarios> crearUsuario (Usuarios request) throws BadAttributeValueExpException {
        String mail = request.getEmail();
        String clave = request.getPassword();
        boolean valido = validarMail(mail);
        boolean validPass = validarPass(clave);
        boolean mailExiste = existeMail(mail);

        if (mailExiste == true) {
            log.info("mail ya estaba registrado");
            throw new UsuariosServiceException("");
        }
        if (valido == false){
                log.info("Error formato correo");
        }
        if (validPass == false){
            log.info("Error formato password");
        }
            Usuarios user = Repository.save(request);
            return new ResponseEntity<>(user, HttpStatus.OK);
    }


    private boolean validarMail (String mail) throws BadAttributeValueExpException {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String email = mail;
        boolean valido =  false;
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
            valido = true;
        }else{
            throw new BadAttributeValueExpException("");
        }
        return valido;
    }

    private boolean validarPass (String clave){
        Pattern pattern = Pattern.compile("^(?=.*[0-9]{2})(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
        String pass = clave;
        boolean password = false;
        Matcher mather = pattern.matcher(pass);
        if (mather.find() == true){
            password = true;
        }else{
            throw new NullPointerException("");
        }
        return password;
    }

    private boolean existeMail (String mail){
        String correo = mail;
        Usuarios correoVa = new Usuarios();
        correoVa.setEmail(correo);
        Example<Usuarios>correoExiste = Example.of(correoVa);
        Iterable<Usuarios>correoEsta = Repository.findAll(correoExiste);
        boolean siExiste = true;
        if (correoEsta.iterator().hasNext() == false){
            siExiste = false;
        }
        return siExiste;
    }
}
