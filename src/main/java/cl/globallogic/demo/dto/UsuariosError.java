package cl.globallogic.demo.dto;


public class UsuariosError {

    private String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public UsuariosError(String message) {
        super();
        this.message = message;
    }


}
