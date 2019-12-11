package cl.globallogic.demo.dto;

import java.util.Calendar;

public class Response {
    private long id;
    private Calendar creacion;
    private Calendar modificado;
    private Calendar last_login;
    private String token;
    private String isactive;

    public long getId() {

        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Calendar getCreacion() {
        return creacion;
    }

    public void setCreacion(Calendar creacion) {
        this.creacion = creacion;
    }

    public Calendar getModificado() {
        return modificado;
    }

    public void setModificado(Calendar modificado) {
        this.modificado = modificado;
    }

    public Calendar getLast_login() {
        return last_login;
    }

    public void setLast_login(Calendar last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public Response() {
        super();
    }
}
