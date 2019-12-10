package cl.globallogic.demo.dto;

import java.util.List;

public class UsuariosError {
    public UsuariosError(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private List<String> details;

    //Getter and setters
}
