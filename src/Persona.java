import java.util.Optional;

public class Persona {


    private final String nombre;
    private final String poblacion;
    private final String edad;


    public Persona(String nombre, String poblacion, String edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }

    public String getNombre() {
        Optional<String> name = Optional.ofNullable(nombre);
        return name.orElse("Desconocida");

    }

    public String getPoblacion() {
        Optional<String> ciudad = Optional.ofNullable(poblacion);
        return ciudad.orElse("Desconocida");
    }

    public String getEdad() {
        Optional<String> age = Optional.ofNullable(edad);
        return age.orElse("Desconocida");
    }

    public String toString() {
        return "Nombre: " + this.getNombre() + " - Población: " + this.getPoblacion() + " - Edad: " + this.getEdad();
    }


}
