package mentoria.nibel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class personaDto implements Serializable {
    private Long id;
    private String nombre;
    private String telefono;
}
