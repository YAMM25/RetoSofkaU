package co.com.sofka.api.model.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pegunta {

    private String  id;
    private String  pregunta;
    private String  respuesta;
}
